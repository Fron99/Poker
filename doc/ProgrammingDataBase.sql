GO
USE PokerAuto
GO


--TRIGGER PARA QUE NO SE PUEDA APOSTAR A UNA PARTIDA QUE YA HAYA PASADO

CREATE OR ALTER TRIGGER CancelBetOldPlays ON UsersBetsRoulettePlays AFTER INSERT AS
BEGIN
	DECLARE @IDRoulettePlay INT
	SELECT @IDRoulettePlay = IDRoulettePlay FROM inserted
	IF((SELECT Result FROM RoulettePlays WHERE ID = @IDRoulettePlay)IS NOT NULL)
	BEGIN
		ROLLBACK
		PRINT 'You can`t bet on a game that has already passed'
	END
END
GO


--TRIGGER PARA NO PERMITIR QUE SE INTRODUZCA UNA JUGADA COMPLETA YA QUE SE DEBERIA DEJAR TIEMPO PARA QUE APOSTARAN LOS JUGADORES

CREATE OR ALTER TRIGGER CancelInsertFullPlays ON RoulettePlays AFTER INSERT AS
BEGIN
	DECLARE @Result INT
	SELECT @Result = Result FROM inserted
	IF(@Result IS NOT NULL)
	BEGIN
		ROLLBACK
		PRINT 'You can`t insert complete play'
	END
END
GO


--TRIGGER PARA ACTUALIZAR LAS EL RESULTADO DE LA TIRADA

	----OBTENER APUESTAS DE UNA JUGADA
	--SELECT *
	--FROM UsersBetsRoulettePlays
	--WHERE IDRoulettePlay = 226

	----OBTENER APUESTAS QUE INCLUYAN AL NUMERO GANADOR
	--SELECT *
	--FROM UsersBetsRoulettePlays AS UBRP
	--INNER JOIN BetsRoulettePlays AS BRP
	--ON BRP.ID = UBRP.IDBetRoulettePlay
	--	INNER JOIN NumbersBetsRoulettePlays AS NBRP
	--	ON NBRP.IDBetRoulettePlay = BRP.ID
	--WHERE IDRoulettePlay = 226 AND IDNumberBetRoulette = (SELECT Result FROM RoulettePlays WHERE ID = 226)


	----OBTENER GANANCIAS GANADORES
	--SELECT UBRP.UsernameUser, UBRP.IDRoulettePlay, UBRP.IDBetRoulettePlay,UBRP.TotalBet,(UBRP.TotalBet*Fee) AS Result
	--FROM UsersBetsRoulettePlays AS UBRP
	--INNER JOIN BetsRoulettePlays AS BRP
	--ON BRP.ID = UBRP.IDBetRoulettePlay
	--	INNER JOIN NumbersBetsRoulettePlays AS NBRP
	--	ON NBRP.IDBetRoulettePlay = BRP.ID
	--WHERE IDRoulettePlay = 226 AND IDNumberBetRoulette = (SELECT Result FROM RoulettePlays WHERE ID = 226)

	
/*
 * NOMBRE: getUsersBetsRoulettePlaysWinners
 * DESCRIPCION: FUNCTION PARA DEVOLVER COMO DEBERIAN SER LOS RESULTADOS DE UNA JUGADA
 * SIGNATURA: CREATE OR ALTER FUNCTION getUsersBetsRoulettePlaysWinners(@IDRoulettePlay INT)
 * PRECONDICIONES: Nada
 * ENTRADA: -ID de la jugada
 * SALIDA: Nada
 * ENTRADA/SALIDA: Nada
 * POSTCONDICIONES: Inserta a todos los jugadores su cantidad que han ganado
 */

CREATE OR ALTER FUNCTION getUsersBetsRoulettePlaysWinners(@IDRoulettePlay INT)
RETURNS TABLE AS RETURN (
	SELECT UBRP.UsernameUser, UBRP.IDRoulettePlay, UBRP.IDBetRoulettePlay,UBRP.TotalBet,(UBRP.TotalBet*Fee) AS Result
	FROM UsersBetsRoulettePlays AS UBRP
	INNER JOIN BetsRoulettePlays AS BRP
	ON BRP.ID = UBRP.IDBetRoulettePlay
		INNER JOIN NumbersBetsRoulettePlays AS NBRP
		ON NBRP.IDBetRoulettePlay = BRP.ID
	WHERE IDRoulettePlay = @IDRoulettePlay AND IDNumberBetRoulette = (SELECT Result FROM RoulettePlays WHERE ID = @IDRoulettePlay)
)
GO


/*
 * NOMBRE: updateBalancePlayers
 * DESCRIPCION: PROCEDURE PARA INCREMENTAR SALDO A LOS GANADORES DE UNA JUGADA
 * SIGNATURA: CREATE OR ALTER PROCEDURE updateBalancePlayers (@IDRoulettePlay INT) AS
 * PRECONDICIONES: Nada
 * ENTRADA: -ID de la jugada
 * SALIDA: Nada
 * ENTRADA/SALIDA: Nada
 * POSTCONDICIONES: Aumenta a los jugadores el saldo con lo que han ganado
 */


CREATE OR ALTER PROCEDURE updateBalancePlayers (@IDRoulettePlay INT) AS
BEGIN

	UPDATE Users
	SET Balance += UBRPW.Result
	FROM getUsersBetsRoulettePlaysWinners(@IDRoulettePlay) AS UBRPW
	WHERE Users.Username = UBRPW.UsernameUser


END
GO


/*
 * NOMBRE: updateResultsBetsUsers
 * DESCRIPCION: PROCEDURE PARA ACTUALIZAR LOS RESULTADOS UNA JUGADA
 * SIGNATURA: CREATE OR ALTER PROCEDURE updateResultsBetsUsers (@IDRoulettePlay INT) AS
 * PRECONDICIONES: Nada
 * ENTRADA: -ID de la jugada
 * SALIDA: Nada
 * ENTRADA/SALIDA: Nada
 * POSTCONDICIONES: Actualiza los resultados de las apuestas realizadas a una jugada colocando su resultado.
 */

CREATE OR ALTER PROCEDURE updateResultsBetsUsers (@IDRoulettePlay INT) AS
BEGIN

	UPDATE UsersBetsRoulettePlays
	SET Result = UBRPW.Result
	FROM getUsersBetsRoulettePlaysWinners(@IDRoulettePlay) AS UBRPW
	WHERE UsersBetsRoulettePlays.UsernameUser = UBRPW.UsernameUser AND UsersBetsRoulettePlays.IDRoulettePlay = UBRPW.IDRoulettePlay AND UsersBetsRoulettePlays.IDBetRoulettePlay = UBRPW.IDBetRoulettePlay

END
GO


CREATE OR ALTER TRIGGER UpdateUsersBetsRoulettePlays ON RoulettePlays AFTER UPDATE AS
BEGIN

	DECLARE @IDRoulettePlay INT
	SELECT @IDRoulettePlay = ID FROM deleted

	EXECUTE updateResultsBetsUsers @IDRoulettePlay
	EXECUTE updateBalancePlayers @IDRoulettePlay

END
GO


--IMPIDE MODIFICAR APUESTAS HECHAS

CREATE OR ALTER TRIGGER DontModifyBet ON UsersBetsRoulettePlays AFTER UPDATE AS
BEGIN
	DECLARE @UsernameUser CHAR(40)
	DECLARE @IDRoulettePlay INT
	DECLARE @IDBetRoulettePlay INT
	DECLARE @TotalBet MONEY

	SELECT @UsernameUser = UsernameUser FROM deleted
	SELECT @IDRoulettePlay = IDRoulettePlay FROM deleted
	SELECT @IDBetRoulettePlay = IDBetRoulettePlay FROM deleted
	SELECT @TotalBet = TotalBet FROM deleted

	IF ((SELECT TotalBet
		FROM UsersBetsRoulettePlays
		WHERE UsernameUser = @UsernameUser
		AND IDRoulettePlay = @IDRoulettePlay
		AND IDBetRoulettePlay = @IDBetRoulettePlay) != @TotalBet)
	BEGIN
		ROLLBACK
	END

END
GO

--LIMITA LA CANTIDAD A APOSTAR

CREATE OR ALTER TRIGGER LimitTotalBetsToRoulettePlay ON UsersBetsRoulettePlays AFTER INSERT AS
BEGIN
	DECLARE @IDRoulettePlay INT
	SELECT @IDRoulettePlay = IDRoulettePlay FROM inserted
	DECLARE @TotalBet INT
	SELECT @TotalBet = (SELECT SUM(TotalBet)
	FROM UsersBetsRoulettePlays
	WHERE IDRoulettePlay = @IDRoulettePlay)

	IF(@TotalBet > 4000)
	BEGIN
		ROLLBACK
	END
END
GO

--LIMITA QUE NO HAYA 2 APUESTAS EN LA MISMA PARTIDA POR EL MISMO JUGADOR

CREATE OR ALTER TRIGGER NotTwoBetForOneRoulettePlay ON UsersBetsRoulettePlays AFTER INSERT AS
BEGIN
	DECLARE @UsernameUser CHAR(40)
	SELECT @UsernameUser = UsernameUser FROM inserted
	DECLARE @IDRoulettePlay INT
	SELECT @IDRoulettePlay = IDRoulettePlay FROM inserted
	IF ((SELECT COUNT(*) FROM UsersBetsRoulettePlays WHERE UsernameUser = @UsernameUser AND IDRoulettePlay = @IDRoulettePlay) > 1)
	BEGIN
		ROLLBACK
	END

END
GO


/*
 * NOMBRE: insertNewRoulettePlay
 * DESCRIPCION: PROCEDIMIENTO PARA GENERAR UNA NUEVA JUGADA
 * SIGNATURA: CREATE OR ALTER PROCEDURE insertNewRoulettePlay AS
 * PRECONDICIONES: Nada
 * ENTRADA: Nada
 * SALIDA: ID de la nueva jugada
 * ENTRADA/SALIDA: Nada
 * POSTCONDICIONES: Devuelve el ID de la nueva jugada creada.
 */


CREATE OR ALTER PROCEDURE insertNewRoulettePlay AS
	BEGIN
		DECLARE @IDNewRoulettePlay INT
		INSERT INTO RoulettePlays(DatePlay) VALUES (CURRENT_TIMESTAMP)	
		SET @IDNewRoulettePlay = @@IDENTITY
	END
	RETURN @IDNewRoulettePlay
GO



/*
 * NOMBRE: generateResultRoulettePlay
 * DESCRIPCION: PROCEDIMIENTO PARA GENERAR RESULTADO DE UNA JUGADA
 * SIGNATURA: CREATE OR ALTER PROCEDURE generateResultRoulettePlay (@IDRoulettePlay INT)
 * PRECONDICIONES: El ID de la partida pasado debe existir 
 * ENTRADA: El ID de la partida a la cual se le quiere generar un resultado 
 * SALIDA: Nada
 * ENTRADA/SALIDA: Nada
 * POSTCONDICIONES: Modifica la partida modificando su resultado por el generado. Si no existe o ya tiene un resultado no podifica nada.
 */


CREATE OR ALTER PROCEDURE generateResultRoulettePlay (@IDRoulettePlay INT) AS
BEGIN

	IF ((SELECT Result FROM RoulettePlays WHERE ID = @IDRoulettePlay) IS NULL)
	BEGIN
		UPDATE RoulettePlays
		SET Result = (SELECT FLOOR(RAND()*(36-10+1))+0)
		WHERE ID = @IDRoulettePlay
	END

END
GO


/*
 * NOMBRE: insertNewBet
 * DESCRIPCION: PROCEDIMIENTO PARA INSERTAR UNA NUEVA APUESTA
 * SIGNATURA: CREATE OR ALTER PROCEDURE insertNewBet (@UsernameUser CHAR(40), @IDRoulettePlay INT, @IDBetRoulettePlay INT, @TotalBet MONEY)
 * PRECONDICIONES: El ID de la partida pasado debe existir 
 * ENTRADA: - El usuario al cual se le va a atribuir la apuesta
 *			- El ID de la partida a la cual se le quiere a�adir una apuesta
 *			- El ID de la apuesta la cual se le quiere a�adir a la partida
 *			- El total que se quiere apostar
 * SALIDA: Nada
 * ENTRADA/SALIDA: Nada
 * POSTCONDICIONES: A�ade una nueva apuesta. Si alguno de los IDs o Usuario no existe no se a�ade. Si la apuesta ya tiene un resultado tampoco se a�ade
 */

CREATE OR ALTER PROCEDURE insertNewBet (@UsernameUser CHAR(40), @IDRoulettePlay INT, @IDBetRoulettePlay INT, @TotalBet MONEY) AS
BEGIN

	INSERT INTO UsersBetsRoulettePlays (UsernameUser, IDRoulettePlay, IDBetRoulettePlay, TotalBet) VALUES (@UsernameUser, @IDRoulettePlay, @IDBetRoulettePlay, @TotalBet)
	UPDATE Users
	SET Balance -= @TotalBet
	WHERE Username = @UsernameUser

END
GO


CREATE OR ALTER PROCEDURE insertNewPokerPlay AS
	BEGIN
	INSERT INTO PokerPlays(Moment) VALUES(CURRENT_TIMESTAMP)
	END
	RETURN @@IDENTITY
GO
