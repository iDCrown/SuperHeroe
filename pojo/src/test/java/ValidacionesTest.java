
import org.junit.jupiter.api.Test;

import com.example.util.Validaciones;

import static org.junit.jupiter.api.Assertions.*;

public class ValidacionesTest {
    @Test
    public void testValidarNombre() {
        assertTrue( Validaciones.validarNombre("Juan Pérez") );
        assertTrue( Validaciones.validarNombre("Ana María") );
        assertFalse( Validaciones.validarNombre(null) );
        assertFalse( Validaciones.validarNombre("A") );
        assertFalse( Validaciones.validarNombre("Nombre Muy Largo Que No Debe Ser Valido") );
        assertFalse( Validaciones.validarNombre("Nombre123") ); // Números no permitidos
        assertFalse( Validaciones.validarNombre("Nombre@") ); // Caracteres especiales no permitidos
        assertFalse( Validaciones.validarNombre("  ") ); // Espacios en blanco no permitidos
        assertFalse( Validaciones.validarNombre("1234545") ); // Solo números no permitidos
    }
}
