package tests;

import org.junit.Test;
import utils.UtilsPlayerImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManagementPlayerImplTest {

    @Test
    public void encriptPassword() {
        UtilsPlayerImpl utilsPlayer = new UtilsPlayerImpl();
        String contra = "HOLA";
        assertEquals(utilsPlayer.encriptPassword(contra),"c6f00988430dbc8e83a7bc7ab5256346");
    }


}