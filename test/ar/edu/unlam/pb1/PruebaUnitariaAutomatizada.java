package ar.edu.unlam.pb1;

import static org.junit.Assert.*;

import org.junit.Test;

public class PruebaUnitariaAutomatizada {
	//prueba git

	@Test
	public void queSePuedaDarDeAltaUnaCasaEnLaInmobiliaria() {
		// Preparacion
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Casa casa1 = new Casa("Alberdi", 640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA);

		// Ejecucion
		inmobiliariaActual.aniadirCasa(casa1);

		// Validacion
		assertNotNull(inmobiliariaActual.getCasas());
		assertTrue(casa1.getEstaDisponible());
	}

	@Test
	public void queSePuedanDarDeAltaDosCasasEnLaInmobiliaria() {
		// Preparacion
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Casa casa1 = new Casa("Alberdi", 640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA);
		Casa casa2 = new Casa("Gaona", 500, "Ramos", 100000.0, true, TipoDeOperacion.VENTA);

		// Ejecucion
		inmobiliariaActual.aniadirCasa(casa1);
		inmobiliariaActual.aniadirCasa(casa2);

		// Validacion
		assertNotNull(inmobiliariaActual.getCasas());
		assertEquals(2, inmobiliariaActual.getCantidadCasasAgregadas());
		assertTrue(casa1.getEstaDisponible());
		assertTrue(casa2.getEstaDisponible());
	}

	@Test
	public void queNoSePuedanDarDeAltaDosCasasConUnaMismaDireccion() {
		// Preparacion
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Casa casa1 = new Casa("Gascon", 500, "Ramos", 50000.0, true, TipoDeOperacion.VENTA);
		Casa casa2 = new Casa("Gascon", 500, "Ramos", 100000.0, true, TipoDeOperacion.VENTA);

		// Ejecucion
		inmobiliariaActual.aniadirCasa(casa1);
		inmobiliariaActual.aniadirCasa(casa2);

		// Validacion
		assertNotNull(inmobiliariaActual.getCasas());
		assertTrue(casa1.getEstaDisponible());
		assertEquals(1, inmobiliariaActual.getCantidadCasasAgregadas());

	}

	@Test
	public void queSePuedaDarDeAltaUnDepartamentoEnLaInmobiliaria() {
		// Preparacion
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Departamento departamento1 = new Departamento("Alberdi", 640, "Haedo", 2, 'A', 50000.0, true,
				TipoDeOperacion.ALQUILER);

		// Ejecucion
		inmobiliariaActual.aniadirDepartamento(departamento1);

		// Validacion
		assertNotNull(inmobiliariaActual.getDepartamentos());
		assertTrue(departamento1.getEstaDisponible());
	}

	@Test
	public void queSePuedanDarDeAltaDosDepartamentoEnLaInmobiliaria() {
		// Preparacion
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Departamento departamento1 = new Departamento("Alberdi", 640, "Haedo", 2, 'A', 50000.0, true,
				TipoDeOperacion.ALQUILER);
		Departamento departamento2 = new Departamento("Cavia", 222, "Lomas del mirador", 2, 'B', 60000.0, true,
				TipoDeOperacion.VENTA);

		// Ejecucion
		inmobiliariaActual.aniadirDepartamento(departamento1);
		inmobiliariaActual.aniadirDepartamento(departamento2);

		// Validacion
		assertNotNull(inmobiliariaActual.getDepartamentos());
		assertEquals(2, inmobiliariaActual.getCantidadDepartamentosAgregados());
		assertTrue(departamento1.getEstaDisponible());
		assertTrue(departamento2.getEstaDisponible());
	}

	@Test
	public void queNoSePuedanDarDeAltaDosDepartamentosConUnaMismaDireccion() {
		// Preparacion
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Departamento departamento1 = new Departamento("Cavia", 222, "Lomas del mirador", 2, 'B', 50000.0, true,
				TipoDeOperacion.ALQUILER);
		Departamento departamento2 = new Departamento("Cavia", 222, "Lomas del mirador", 2, 'B', 75000.0, true,
				TipoDeOperacion.VENTA);

		// Ejecucion
		inmobiliariaActual.aniadirDepartamento(departamento1);
		inmobiliariaActual.aniadirDepartamento(departamento2);

		// Validacion
		assertNotNull(inmobiliariaActual.getDepartamentos());
		assertTrue(departamento1.getEstaDisponible());
		assertEquals(1, inmobiliariaActual.getCantidadDepartamentosAgregados());

	}

	@Test // avisa que se debe ejecutar bajo el entorno de JUnit
	public void queSiTengoTresCasasDeCincuentaCienYSesentaMilElPromedioSeaSetentaMil() {

		// Preparacion de datos: necesitamos crear la inmobiliaria, las casas
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av. Rivadavia", "sandovalInmobiliaria@mail.com",
				1122334455);
		Casa casa1 = new Casa("Alberdi", 640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA);
		Casa casa2 = new Casa("Gaona", 500, "Ramos", 100000.0, true, TipoDeOperacion.VENTA);
		Casa casa3 = new Casa("Peron", 100, "San Justo", 60000.0, true, TipoDeOperacion.VENTA);

		// Ejecucion
		inmobiliariaActual.aniadirCasa(casa1);
		inmobiliariaActual.aniadirCasa(casa2);
		inmobiliariaActual.aniadirCasa(casa3);

		// validacion
		assertEquals(70000.0, inmobiliariaActual.calcularPrecioPromedioDeCasas(), 0.01);
	}

	@Test // avisa que se debe ejecutar bajo el entorno de JUnit
	public void queSiTengoTresDepartamentosDeCincuentaCienYSesentaMilElPromedioSeaSetentaMil() {

		// Preparacion de datos: necesitamos crear la inmobiliaria, las casas
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av. Rivadavia", "sandovalInmobiliaria@mail.com",
				1122334455);
		Departamento departamento1 = new Departamento("Alberdi", 640, "Haedo", 1, 'A', 50000.0, true,
				TipoDeOperacion.VENTA);
		Departamento departamento2 = new Departamento("Gaona", 500, "Ramos", 2, 'A', 100000.0, true,
				TipoDeOperacion.ALQUILER);
		Departamento departamento3 = new Departamento("Peron", 100, "San Justo", 1, 'B', 60000.0, true,
				TipoDeOperacion.VENTA);

		// Ejecucion
		inmobiliariaActual.aniadirDepartamento(departamento1);
		inmobiliariaActual.aniadirDepartamento(departamento2);
		inmobiliariaActual.aniadirDepartamento(departamento3);

		// validacion
		assertEquals(70000.0, inmobiliariaActual.calcularPrecioPromedioDeDepartamentos(), 0.01);
	}

	@Test
	public void queSiNoTengoCasasElPrecioPromedioDeCero() {

		// Preparacion de datos
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av. Rivadavia", "sandovalInmobiliaria@mail.com",
				1122334455);

		// Ejecucion
		// validacion
		assertEquals(0.0, inmobiliariaActual.calcularPrecioPromedioDeCasas(), 0.01);
	}

	@Test
	public void queSiBuscoUnaCasaPorRangoDePrecioLaEncuentreCorrectamente() {
		// Preparacion
		Double precioMinimo = 0.0;
		Double precioMaximo = 60000.0;

		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);

		Casa casa1 = new Casa("Alberdi", 640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA);
		Casa casa2 = new Casa("Gaona", 500, "Ramos", 100000.0, true, TipoDeOperacion.VENTA);
		Casa casa3 = new Casa("Peron", 100, "San Justo", 60000.0, true, TipoDeOperacion.VENTA);

		// Ejecucion
		inmobiliariaActual.aniadirCasa(casa1);
		inmobiliariaActual.aniadirCasa(casa2);
		inmobiliariaActual.aniadirCasa(casa3);

		Casa casasEncontradasDentroRango[] = inmobiliariaActual.buscarCasasPorRangoDePrecio(precioMinimo, precioMaximo);

		// Validacion
		assertNotNull(casasEncontradasDentroRango);
		assertEquals(2, casasEncontradasDentroRango.length);

	}

	@Test
	public void queSiBuscoUnaCasaPorRangoDePrecioYNoSeEncuentraNingunaElArrayResultadoEsteNull() {
		// Preparacion
		Double precioMinimo = 0.0;
		Double precioMaximo = 40000.0;
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Casa casa1 = new Casa("Alberdi", 640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA);
		Casa casa2 = new Casa("Gaona", 500, "Ramos", 100000.0, true, TipoDeOperacion.VENTA);
		Casa casa3 = new Casa("Peron", 100, "San Justo", 60000.0, true, TipoDeOperacion.VENTA);

		// Ejecucion
		inmobiliariaActual.aniadirCasa(casa1);
		inmobiliariaActual.aniadirCasa(casa2);
		inmobiliariaActual.aniadirCasa(casa3);
		Casa casasEncontradasDentroRango[] = inmobiliariaActual.buscarCasasPorRangoDePrecio(precioMinimo, precioMaximo);

		// Validacion
		assertNull(casasEncontradasDentroRango);
	}

	@Test
	public void queSiUnaCasaEstaDisponibleElMetodoGetEstaDisponibilidadDeTrue() {
		// Preparacion
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Casa casa1 = new Casa("Alberdi", 640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA);

		// Ejecucion
		inmobiliariaActual.aniadirCasa(casa1);

		// Validacion
		assertTrue(casa1.getEstaDisponible());
	}

	@Test
	public void queSiUnaCasaEstaALaVentaDeTrueParaVentaYFalseParaAlquiler() {
		// Preparacion
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Casa casa1 = new Casa("Alberdi", 640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA);

		// Ejecucion
		inmobiliariaActual.aniadirCasa(casa1);

		// Validacion
		assertTrue(casa1.estaDisponibleParaVenta());
		assertFalse(casa1.estaDisponibleParaAlquiler());
	}

}
