package tests;

import managements.ManagementPlayerImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManagementPlayerImplTest {

    @Test
    public void encriptPassword() {
        ManagementPlayerImpl MPI = new ManagementPlayerImpl();
        String contra = "HOLA";
        assertEquals(MPI.encriptPassword(contra),"c6f00988430dbc8e83a7bc7ab5256346");
    }


}