package ar.edu.unahur.obj2.w2j.planes;

import ar.edu.unahur.obj2.w2j.contenidos.Documental;
import ar.edu.unahur.obj2.w2j.contenidos.Pelicula;
import ar.edu.unahur.obj2.w2j.contenidos.series.Episodio;
import ar.edu.unahur.obj2.w2j.contenidos.series.Serie;
import ar.edu.unahur.obj2.w2j.contenidos.series.Temporada;
import java.util.ArrayList; // Para la implementación concreta ArrayList
import java.util.List; // Para la interfaz List
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests de Usuarios y planes")
class JuanTest {

    // Declaramos las variables de instancia para que sean accesibles en todos los tests
    private PlanBasico planBasico1;
    private PlanBasico planBasico2;
    private Usuario juan;
    private Usuario pedro;

    private Pelicula pelicula1;
    private Pelicula pelicula2;

    private Serie serieRecuerdos;
    private Temporada recuerdosTemporada1;
    private Episodio recuerdosEpisodio1;
    private Episodio recuerdosEpisodio2;

    private Documental docuGobstones;
    private Documental docuWollok;
    private Documental docuJava;
    private Documental docuTerminal;

    // Esto se ejecuta antes de cada test
    @BeforeEach
    void setUp() {
        // 1. Inicializar planes
        planBasico1 = new PlanBasico(5.0, 5);
        planBasico2 = new PlanBasico(10.0, 15);

        // 2. Inicializar usuarios
        juan = new Usuario("Juan", planBasico1);
        pedro = new Usuario("Pedro", planBasico2);

        // 3. Inicializar contenidos
        pelicula1 = new Pelicula("Aprendiendo a vivir", 5.0);
        pelicula2 = new Pelicula("Aprendiendo a vivir 2", 5.0);

        serieRecuerdos = new Serie("Recuerdos", 20.0);
        recuerdosTemporada1 = new Temporada("Temporada 1", 0.0, 1);
        recuerdosEpisodio1 = new Episodio("Primer día", 10.0, 1);
        recuerdosEpisodio2 = new Episodio("La vida es dura", 15.0, 2);

        recuerdosTemporada1.agregarEpisodio(recuerdosEpisodio1);
        recuerdosTemporada1.agregarEpisodio(recuerdosEpisodio2);
        serieRecuerdos.agregarTemporada(recuerdosTemporada1);

        Documental docuGobstones = new Documental("Gobstones", 20.0);
        Documental docuWollok = new Documental("Wollok", 25.0);
        Documental docuJava = new Documental("Java", 30.0);
        Documental docuTerminal = new Documental("Terminal", 20.0);

        // Hacemos que Juan y Pedro miren los doucmentales

        List<Usuario> usuarios = new ArrayList<>(List.of(juan, pedro));

        usuarios.forEach(u -> {
            u.verContenido(docuGobstones);
            u.verContenido(docuWollok);
            u.verContenido(docuJava);
            u.verContenido(docuTerminal);
        });
    }

    @Test
    @DisplayName(
        "Juan con un Plan Básico de costo fijo 5 y 5 contenidos se ve todos los documentales y luego ve Aprendiendo a vivir 1 y 2 y la serie Recuerdos. Se excede en 2 contenidos 30 usd"
    )
    /*
    Juan tiene `planBasico1`: **Costo Fijo: 5.0** y **Bonificados: 5**.

    **Contenidos que vio (en orden):**
    1.  `docuGobstones` (Costo: 30.0) -> *Índice 0*
    2.  `docuWollok` (Costo: 37.5) -> *Índice 1*
    3.  `docuJava` (Costo: 45.0) -> *Índice 2*
    4.  `docuTerminal` (Costo: 30.0) -> *Índice 3*
    5.  `pelicula1` (Costo: 5.0) -> *Índice 4*
    6.  `pelicula2` (Costo: 5.0) -> *Índice 5*
    7.  `serieRecuerdos` (Costo: 32.5) -> *Índice 6*

    **¿Qué factura el Plan Básico?**
    El código hace `subList(5, 7)`, lo que toma los elementos en las posiciones **5 y 6** (los últimos dos).
    *   Posición 5: `pelicula2` ($5.0$)
    *   Posición 6: `serieRecuerdos` ($32.5$)

    **Total Juan:** `5.0 (fijo) + 5.0 (peli2) + 32.5 (serie) =` **`42.5`**
    *


    */
    void testJuanPlanBasicoExcede() {
        juan.verContenido(pelicula1);
        juan.verContenido(pelicula2);
        juan.verContenido(serieRecuerdos);

        Assertions.assertEquals(42.5, juan.getPlan().getCosto());
    }

    @Test
    @DisplayName(
        "Pedro con un Plan Básico de costo fijo 10 y 15 contenidos ve el mismo contendio que Juan y paga 10"
    )
    void testPedroPlanBasico() {
        pedro.verContenido(pelicula1);
        pedro.verContenido(pelicula2);
        pedro.verContenido(serieRecuerdos);

        Assertions.assertEquals(10.0, pedro.getPlan().getCosto());
    }
}
