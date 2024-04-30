package ar.edu.unlam.pb1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;

public class PruebaUnitariaAutomatizada {

	@Test
	public void queSePuedaAgregarUnaCasaYLaDimensionDelArraySeaLaMinimaPosible() {
		final Integer DIMENSION_DEL_ARRAY_ESPERADA = 1;

		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Casa casa1 = new Casa("Alberdi", 640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA);

		inmobiliariaActual.aniadirCasa(casa1);

		assertEquals(DIMENSION_DEL_ARRAY_ESPERADA, (Integer) inmobiliariaActual.getCasas().size());
	}

	@Test
	public void queSePuedanAgregarTresCasasYLaDimensionDelArraySeaTres() {
		final Integer DIMENSION_DEL_ARRAY_ESPERADA = 3;

		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Casa casa1 = new Casa("Alberdi", 640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA);
		Casa casa2 = new Casa("Gaona", 500, "Ramos", 100000.0, true, TipoDeOperacion.VENTA);
		Casa casa3 = new Casa("Peron", 100, "San Justo", 60000.0, true, TipoDeOperacion.VENTA);

		inmobiliariaActual.aniadirCasa(casa1);
		inmobiliariaActual.aniadirCasa(casa2);
		inmobiliariaActual.aniadirCasa(casa3);

		assertEquals(DIMENSION_DEL_ARRAY_ESPERADA, (Integer) inmobiliariaActual.getCasas().size());
	}

	@Test
	public void queSePuedaAgregarUnClienteYLaDimensionDelArraySeaLaMinimaPosible() {
		final Integer DIMENSION_DEL_ARRAY_ESPERADA = 1;

		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Cliente cliente1 = new Cliente(123, "Pablo", "Rodriguez", TiposDePropiedades.DEPARTAMENTO, false);

		inmobiliariaActual.añadirCliente(cliente1);

		assertEquals(DIMENSION_DEL_ARRAY_ESPERADA, (Integer) inmobiliariaActual.getClientes().size());
	}

	@Test
	public void queSePuedanAgregarTresClientesYLaDimensionDelArraySeaTres() {
		final Integer DIMENSION_DEL_ARRAY_ESPERADA = 3;

		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Cliente cliente1 = new Cliente(123, "Pablo", "Rodriguez", TiposDePropiedades.DEPARTAMENTO, false);
		Cliente cliente2 = new Cliente(122, "Diego", "Diaz", TiposDePropiedades.CASA, false);
		Cliente cliente3 = new Cliente(133, "Luisa", "Paez", TiposDePropiedades.PH, true);

		inmobiliariaActual.añadirCliente(cliente1);
		inmobiliariaActual.añadirCliente(cliente2);
		inmobiliariaActual.añadirCliente(cliente3);

		assertEquals(DIMENSION_DEL_ARRAY_ESPERADA, (Integer) inmobiliariaActual.getClientes().size());
	}

	@Test
	public void queSiAgregoTresClientesConDosClientesRepetidosLaDimensionDelArraySeaDos() {
		final Integer DIMENSION_DEL_ARRAY_ESPERADA = 2;

		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Cliente cliente1 = new Cliente(123, "Pablo", "Rodriguez", TiposDePropiedades.DEPARTAMENTO, false);
		Cliente cliente2 = new Cliente(122, "Diego", "Diaz", TiposDePropiedades.CASA, false);

		inmobiliariaActual.añadirCliente(cliente1);
		inmobiliariaActual.añadirCliente(cliente2);
		inmobiliariaActual.añadirCliente(cliente2);

		assertEquals(DIMENSION_DEL_ARRAY_ESPERADA, (Integer) inmobiliariaActual.getClientes().size());
	}

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
		assertEquals(2, inmobiliariaActual.getCasas().size());
		assertTrue(casa1.getEstaDisponible());
		assertTrue(casa2.getEstaDisponible());
	}

	@Test
	public void queSePuedanOrdenarLasCasasPorPrecio() {
		// Preparacion
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Casa casa1 = new Casa("Alberdi", 640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA);
		Casa casa2 = new Casa("Gaona", 500, "Ramos", 100000.0, true, TipoDeOperacion.VENTA);
		Casa casa3 = new Casa("Peron", 100, "San Justo", 60000.0, true, TipoDeOperacion.VENTA);

		// Ejecucion
		inmobiliariaActual.aniadirCasa(casa1);
		inmobiliariaActual.aniadirCasa(casa2);
		inmobiliariaActual.aniadirCasa(casa3);
		ArrayList<Casa> casasOrdenadas = inmobiliariaActual.ordenarCasasPorPrecio();

		// Validacion
		assertEquals(casa1, casasOrdenadas.get(0));
		assertEquals(casa3, casasOrdenadas.get(1));
		assertEquals(casa2, casasOrdenadas.get(2));
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
		assertEquals(2, inmobiliariaActual.getDepartamentos().size());
		assertTrue(departamento1.getEstaDisponible());
		assertTrue(departamento2.getEstaDisponible());
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

	@Test
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

		LinkedList<Casa> casasEncontradasDentroRango = inmobiliariaActual.buscarCasasPorRangoDePrecio(precioMinimo,
				precioMaximo);

		// Validacion
		assertNotNull(casasEncontradasDentroRango);
		assertEquals(2, casasEncontradasDentroRango.size());

	}

	@Test
	public void queSiBuscoUnaCasaPorRangoDePrecioYNoSeEncuentraNingunaElArrayResultadoEsteVacio() {
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
		LinkedList<Casa> casasEncontradasDentroRango = inmobiliariaActual.buscarCasasPorRangoDePrecio(precioMinimo,
				precioMaximo);

		// Validacion
		assertTrue(casasEncontradasDentroRango.isEmpty());
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
		assertTrue(casa1.estaDisponiblePara(TipoDeOperacion.VENTA));
		assertFalse(casa1.estaDisponiblePara(TipoDeOperacion.ALQUILER));
	}

	@Test
	public void queSePuedanOrdenarLasCasasPorLocalidad() {
		// Preparacion
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Casa casa1 = new Casa("Alberdi", 640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA);
		Casa casa2 = new Casa("Gaona", 500, "Ramos", 100000.0, true, TipoDeOperacion.VENTA);
		Casa casa3 = new Casa("Peron", 100, "San Justo", 60000.0, true, TipoDeOperacion.VENTA);

		// Ejecucion
		inmobiliariaActual.aniadirCasa(casa1);
		inmobiliariaActual.aniadirCasa(casa2);
		inmobiliariaActual.aniadirCasa(casa3);
		ArrayList<Casa> casasOrdenadas = inmobiliariaActual.ordenarCasasPorLocalidad();

		// Validacion
		assertEquals(casa1, casasOrdenadas.get(0));
		assertEquals(casa2, casasOrdenadas.get(1));
		assertEquals(casa3, casasOrdenadas.get(2));
	}

	@Test
	public void queSiBuscoUnaCasaConUnaLocalidadEspecificaYEncuentraUnaQueCoincidaDentroDeLaListaLaDevuelva() {
		String localidadDeseada = "Haedo";
		Integer cantidadCasasEncontradas = 1;
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Casa casa1 = new Casa("Alberdi", 640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA);
		Casa casa2 = new Casa("Gaona", 500, "Ramos", 100000.0, true, TipoDeOperacion.VENTA);
		Casa casa3 = new Casa("Peron", 100, "San Justo", 60000.0, true, TipoDeOperacion.VENTA);

		inmobiliariaActual.aniadirCasa(casa1);
		inmobiliariaActual.aniadirCasa(casa2);
		inmobiliariaActual.aniadirCasa(casa3);
		
		ArrayList<Casa> casasEncontradas = inmobiliariaActual.buscarCasasPorLocalidad(localidadDeseada);

	    assertFalse(casasEncontradas.isEmpty());
	    assertEquals(cantidadCasasEncontradas, (Integer)casasEncontradas.size());
	}
	
	@Test
	public void queSiBuscoCasasUnaLocalidadEspecificaYEncuentraDosQueCoincidanDentroDeLaListaLasDevuelva() {
		String localidadDeseada = "Haedo";
		Integer cantidadCasasEncontradas = 2;
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Casa casa1 = new Casa("Alberdi", 640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA);
		Casa casa2 = new Casa("Gaona", 500, "Haedo", 100000.0, true, TipoDeOperacion.VENTA);
		Casa casa3 = new Casa("Peron", 100, "San Justo", 60000.0, true, TipoDeOperacion.VENTA);

		inmobiliariaActual.aniadirCasa(casa1);
		inmobiliariaActual.aniadirCasa(casa2);
		inmobiliariaActual.aniadirCasa(casa3);
		
		ArrayList<Casa> casasEncontradas = inmobiliariaActual.buscarCasasPorLocalidad(localidadDeseada);

	    assertFalse(casasEncontradas.isEmpty());
	    assertEquals(cantidadCasasEncontradas, (Integer)casasEncontradas.size());
	}
	
//	En realidad se puede vender la misma propiedad por distintos vendedores,
//  por eso este test no sería válido
//
//	@Test
//	public void queNoSePuedanDarDeAltaDosCasasConUnaMismaDireccion() {
//		// Preparacion
//		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
//				1122334455);
//		Casa casa1 = new Casa("Gascon", 500, "Ramos", 50000.0, true, TipoDeOperacion.VENTA);
//		Casa casa2 = new Casa("Gascon", 500, "Ramos", 100000.0, true, TipoDeOperacion.VENTA);
//
//		// Ejecucion
//		inmobiliariaActual.aniadirCasa(casa1);
//		inmobiliariaActual.aniadirCasa(casa2);
//
//		// Validacion
//		assertNotNull(inmobiliariaActual.getCasas());
//		assertTrue(casa1.getEstaDisponible());
//		assertEquals(1, inmobiliariaActual.getCasas());
//	}
//	
// @Test
//	public void queNoSePuedanDarDeAltaDosDepartamentosConUnaMismaDireccion() {
//		// Preparacion
//		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
//				1122334455);
//		Departamento departamento1 = new Departamento("Cavia", 222, "Lomas del mirador", 2, 'B', 50000.0, true,
//				TipoDeOperacion.ALQUILER);
//		Departamento departamento2 = new Departamento("Cavia", 222, "Lomas del mirador", 2, 'B', 75000.0, true,
//				TipoDeOperacion.VENTA);
//
//		// Ejecucion
//		inmobiliariaActual.aniadirDepartamento(departamento1);
//		inmobiliariaActual.aniadirDepartamento(departamento2);
//
//		// Validacion
//		assertNotNull(inmobiliariaActual.getDepartamentos());
//		assertTrue(departamento1.getEstaDisponible());
//		assertEquals(1, inmobiliariaActual.getDepartamentos());
//
//	}

}
