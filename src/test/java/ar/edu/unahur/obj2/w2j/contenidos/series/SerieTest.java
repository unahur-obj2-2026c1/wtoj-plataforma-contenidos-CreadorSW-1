package ar.edu.unahur.obj2.w2j.contenidos.series; // Asegurate de que el paquete sea correcto

import ar.edu.unahur.obj2.w2j.contenidos.Contenido; // Necesario si Contenido no está en el mismo paquete
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// Para emular 'describe "Tests Serie Recuerdos"'
@DisplayName("Tests para la clase Serie")
public class SerieTest {

    // Equivalente a 'const recuerdosEpisodio1 = new Episodio(...)' en Wollok
    // Declaramos las variables de instancia para que sean accesibles en todos los tests
    private Episodio recuerdosEpisodio1;
    private Episodio recuerdosEpisodio2;
    private Temporada recuerdosTemporada1;
    private Serie serieRecuerdos;

    // Esto se ejecuta antes de CADA test, equivalente a un 'method initialize()' si lo tuvieras,
    // o para inicializar tus 'const' de Wollok en un contexto de test.
    @BeforeEach
    void setUp() {
        recuerdosEpisodio1 = new Episodio("Primer dia", 10.0, 1); // Notá el .0 para el double
        recuerdosEpisodio2 = new Episodio("La vida es dura", 15.0, 2);

        recuerdosTemporada1 = new Temporada("Temporada 1", 0.0, 1); // El costo base de la temporada es 0

        serieRecuerdos = new Serie("Recuerdos", 20.0);
    }

    // Equivalente a 'test "La serie Recuerdos con un costo base de 20 y 1 temporada..."'
    @Test
    @DisplayName(
        "La serie Recuerdos con un costo base de 20 y 1 temporada de 2 episodios de 10 y 15 de costo respectivamente, tiene un costo de 20 + (25/2)"
    )
    void testCostoSerieRecuerdos() {
        // Configuramos el estado de los objetos, como lo harías en el test de Wollok
        recuerdosTemporada1.agregarEpisodio(recuerdosEpisodio1);
        recuerdosTemporada1.agregarEpisodio(recuerdosEpisodio2);
        serieRecuerdos.agregarTemporada(recuerdosTemporada1);

        // La aserción: assert.equals(expected, actual)
        // Usamos Assesrtions.assertEquals de JUnit
        Assertions.assertEquals(20.0 + (25.0 / 2.0), serieRecuerdos.getCosto());
    }
}
