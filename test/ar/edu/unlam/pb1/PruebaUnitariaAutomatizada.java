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

		inmobiliariaActual.aniadirPropiedad(casa1);

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

		inmobiliariaActual.aniadirPropiedad(casa1);
		inmobiliariaActual.aniadirPropiedad(casa2);
		inmobiliariaActual.aniadirPropiedad(casa3);

		assertEquals(DIMENSION_DEL_ARRAY_ESPERADA, (Integer) inmobiliariaActual.getCasas().size());
	}

	@Test
	public void queSePuedaAgregarUnClienteYLaDimensionDelArraySeaLaMinimaPosible() {
		final Integer DIMENSION_DEL_ARRAY_ESPERADA = 1;

		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Cliente cliente1 = new Cliente(123, "Pablo", "Rodriguez", TiposDePropiedades.DEPARTAMENTO, false);

		inmobiliariaActual.aniadirCliente(cliente1);

		assertEquals(DIMENSION_DEL_ARRAY_ESPERADA, (Integer) inmobiliariaActual.getClientes().size());
	}

	@Test
	public void queNoSePuedaAgregarUnClienteConDNINulo() {
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Cliente clienteConDNINulo = new Cliente(null, "Pablo", "Rodriguez", TiposDePropiedades.DEPARTAMENTO, false);
		Boolean sePuedeAgregar = inmobiliariaActual.aniadirCliente(clienteConDNINulo);

		assertFalse(sePuedeAgregar);
	}

	@Test
	public void queNoSePuedaAgregarDosClientesTotalmenteIguales() {
		final Integer DIMENSION_DEL_ARRAY_ESPERADA = 1;

		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Cliente cliente1 = new Cliente(123, "Pablo", "Rodriguez", TiposDePropiedades.DEPARTAMENTO, false);
		Cliente cliente2 = new Cliente(123, "Pablo", "Rodriguez", TiposDePropiedades.DEPARTAMENTO, false);

		inmobiliariaActual.aniadirCliente(cliente1);
		inmobiliariaActual.aniadirCliente(cliente2);

		assertEquals(DIMENSION_DEL_ARRAY_ESPERADA, (Integer) inmobiliariaActual.getClientes().size());
	}

	@Test
	public void queNoSePuedaAgregarDosClientesConIgualDNI() {
		final Integer DIMENSION_DEL_ARRAY_ESPERADA = 1;

		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Cliente cliente1 = new Cliente(123, "Pablo", "Rodriguez", TiposDePropiedades.DEPARTAMENTO, false);
		Cliente cliente2 = new Cliente(123, "Miriam", "MArtinez", TiposDePropiedades.CASA, false);

		inmobiliariaActual.aniadirCliente(cliente1);
		inmobiliariaActual.aniadirCliente(cliente2);

		assertEquals(DIMENSION_DEL_ARRAY_ESPERADA, (Integer) inmobiliariaActual.getClientes().size());
	}

	@Test
	public void queSePuedanAgregarTresClientesYLaDimensionDelArraySeaTres() {
		final Integer DIMENSION_DEL_ARRAY_ESPERADA = 3;

		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Cliente cliente1 = new Cliente(111, "Pablo", "Rodriguez", TiposDePropiedades.DEPARTAMENTO, false);
		Cliente cliente2 = new Cliente(222, "Diego", "Diaz", TiposDePropiedades.CASA, false);
		Cliente cliente3 = new Cliente(333, "Luisa", "Paez", TiposDePropiedades.PH, true);

		inmobiliariaActual.aniadirCliente(cliente1);
		inmobiliariaActual.aniadirCliente(cliente2);
		inmobiliariaActual.aniadirCliente(cliente3);

		assertEquals(DIMENSION_DEL_ARRAY_ESPERADA, (Integer) inmobiliariaActual.getClientes().size());
	}

	@Test
	public void queSiAgregoTresClientesConDosClientesRepetidosLaDimensionDelArraySeaDos() {
		final Integer DIMENSION_DEL_ARRAY_ESPERADA = 2;

		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Cliente cliente1 = new Cliente(123, "Pablo", "Rodriguez", TiposDePropiedades.DEPARTAMENTO, false);
		Cliente cliente2 = new Cliente(122, "Diego", "Diaz", TiposDePropiedades.CASA, false);

		inmobiliariaActual.aniadirCliente(cliente1);
		inmobiliariaActual.aniadirCliente(cliente2);
		inmobiliariaActual.aniadirCliente(cliente2);

		assertEquals(DIMENSION_DEL_ARRAY_ESPERADA, (Integer) inmobiliariaActual.getClientes().size());
	}

	@Test
	public void queSePuedaDarDeAltaUnaCasaEnLaInmobiliaria() {
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Casa casa1 = new Casa("Alberdi", 640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA);

		inmobiliariaActual.aniadirPropiedad(casa1);

		assertNotNull(inmobiliariaActual.getCasas());
		assertTrue(casa1.getEstaDisponible());
	}

	@Test
	public void queSePuedanDarDeAltaDosCasasEnLaInmobiliaria() {
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Casa casa1 = new Casa("Alberdi", 640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA);
		Casa casa2 = new Casa("Gaona", 500, "Ramos", 100000.0, true, TipoDeOperacion.VENTA);

		inmobiliariaActual.aniadirPropiedad(casa1);
		inmobiliariaActual.aniadirPropiedad(casa2);

		assertNotNull(inmobiliariaActual.getCasas());
		assertEquals(2, inmobiliariaActual.getCasas().size());
		assertTrue(casa1.getEstaDisponible());
		assertTrue(casa2.getEstaDisponible());
	}

	@Test
	public void queSePuedanOrdenarLasCasasPorPrecio() {
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Casa casa1 = new Casa("Alberdi", 640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA);
		Casa casa2 = new Casa("Gaona", 500, "Ramos", 100000.0, true, TipoDeOperacion.VENTA);
		Casa casa3 = new Casa("Peron", 100, "San Justo", 60000.0, true, TipoDeOperacion.VENTA);

		inmobiliariaActual.aniadirPropiedad(casa1);
		inmobiliariaActual.aniadirPropiedad(casa2);
		inmobiliariaActual.aniadirPropiedad(casa3);
		ArrayList<Casa> casasOrdenadas = inmobiliariaActual.ordenarCasasPorPrecio();

		assertEquals(casa1, casasOrdenadas.get(0));
		assertEquals(casa3, casasOrdenadas.get(1));
		assertEquals(casa2, casasOrdenadas.get(2));
	}

	@Test
	public void queSePuedaDarDeAltaUnDepartamentoEnLaInmobiliaria() {
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Departamento departamento1 = new Departamento("Alberdi", 640, "Haedo", 2, 'A', 50000.0, true,
				TipoDeOperacion.ALQUILER);

		inmobiliariaActual.aniadirPropiedad(departamento1);

		assertNotNull(inmobiliariaActual.getDepartamentos());
		assertTrue(departamento1.getEstaDisponible());
	}

	@Test
	public void queSePuedanDarDeAltaDosDepartamentoEnLaInmobiliaria() {
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Departamento departamento1 = new Departamento("Alberdi", 640, "Haedo", 2, 'A', 50000.0, true,
				TipoDeOperacion.ALQUILER);
		Departamento departamento2 = new Departamento("Cavia", 222, "Lomas del mirador", 2, 'B', 60000.0, true,
				TipoDeOperacion.VENTA);

		inmobiliariaActual.aniadirPropiedad(departamento1);
		inmobiliariaActual.aniadirPropiedad(departamento2);

		assertNotNull(inmobiliariaActual.getDepartamentos());
		assertEquals(2, inmobiliariaActual.getDepartamentos().size());
		assertTrue(departamento1.getEstaDisponible());
		assertTrue(departamento2.getEstaDisponible());
	}

	@Test
	public void queSiTengoTresCasasDeCincuentaCienYSesentaMilElPromedioSeaSetentaMil() {
		Integer tipoPropiedadDeLaQueCalcularPromedio = 1;
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av. Rivadavia", "sandovalInmobiliaria@mail.com",
				1122334455);
		Casa casa1 = new Casa("Alberdi", 640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA);
		Casa casa2 = new Casa("Gaona", 500, "Ramos", 100000.0, true, TipoDeOperacion.VENTA);
		Casa casa3 = new Casa("Peron", 100, "San Justo", 60000.0, true, TipoDeOperacion.VENTA);

		inmobiliariaActual.aniadirPropiedad(casa1);
		inmobiliariaActual.aniadirPropiedad(casa2);
		inmobiliariaActual.aniadirPropiedad(casa3);

		assertEquals(70000.0, inmobiliariaActual.calcularPromedioPrecio(tipoPropiedadDeLaQueCalcularPromedio), 0.01);
	}

	@Test
	public void queSiTengoTresDepartamentosDeCincuentaCienYSesentaMilElPromedioSeaSetentaMil() {
		Integer tipoPropiedadDeLaQueCalcularPromedio = 2;

		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av. Rivadavia", "sandovalInmobiliaria@mail.com",
				1122334455);
		Departamento departamento1 = new Departamento("Alberdi", 640, "Haedo", 1, 'A', 50000.0, true,
				TipoDeOperacion.VENTA);
		Departamento departamento2 = new Departamento("Gaona", 500, "Ramos", 2, 'A', 100000.0, true,
				TipoDeOperacion.ALQUILER);
		Departamento departamento3 = new Departamento("Peron", 100, "San Justo", 1, 'B', 60000.0, true,
				TipoDeOperacion.VENTA);

		inmobiliariaActual.aniadirPropiedad(departamento1);
		inmobiliariaActual.aniadirPropiedad(departamento2);
		inmobiliariaActual.aniadirPropiedad(departamento3);

		assertEquals(70000.0, inmobiliariaActual.calcularPromedioPrecio(tipoPropiedadDeLaQueCalcularPromedio), 0.01);
	}

	@Test
	public void queSiNoTengoCasasElPrecioPromedioDeCero() {
		Integer tipoPropiedadDeLaQueCalcularPromedio = 1;
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av. Rivadavia", "sandovalInmobiliaria@mail.com",
				1122334455);

		assertEquals(0.0, inmobiliariaActual.calcularPromedioPrecio(tipoPropiedadDeLaQueCalcularPromedio), 0.01);
	}

	@Test
	public void queSiBuscoUnaCasaPorRangoDePrecioLaEncuentreCorrectamente() {
		Double precioMinimo = 0.0;
		Double precioMaximo = 60000.0;

		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);

		Casa casa1 = new Casa("Alberdi", 640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA);
		Casa casa2 = new Casa("Gaona", 500, "Ramos", 100000.0, true, TipoDeOperacion.VENTA);
		Casa casa3 = new Casa("Peron", 100, "San Justo", 60000.0, true, TipoDeOperacion.VENTA);

		inmobiliariaActual.aniadirPropiedad(casa1);
		inmobiliariaActual.aniadirPropiedad(casa2);
		inmobiliariaActual.aniadirPropiedad(casa3);

		LinkedList<Casa> casasEncontradasDentroRango = inmobiliariaActual.buscarCasasPorRangoDePrecio(precioMinimo,
				precioMaximo);

		assertNotNull(casasEncontradasDentroRango);
		assertEquals(2, casasEncontradasDentroRango.size());

	}

	@Test
	public void queSiUnaCasaEstaDisponibleElMetodoGetEstaDisponibilidadDeTrue() {
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Casa casa1 = new Casa("Alberdi", 640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA);

		inmobiliariaActual.aniadirPropiedad(casa1);

		assertTrue(casa1.getEstaDisponible());
	}

	@Test
	public void queSiUnaCasaEstaALaVentaDeTrueParaVentaYFalseParaAlquiler() {
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Casa casa1 = new Casa("Alberdi", 640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA);

		inmobiliariaActual.aniadirPropiedad(casa1);

		assertTrue(casa1.estaDisponiblePara(TipoDeOperacion.VENTA));
		assertFalse(casa1.estaDisponiblePara(TipoDeOperacion.ALQUILER));
	}

	@Test
	public void queSePuedanOrdenarLasCasasPorLocalidad() {
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Casa casa1 = new Casa("Alberdi", 640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA);
		Casa casa2 = new Casa("Gaona", 500, "Ramos", 100000.0, true, TipoDeOperacion.VENTA);
		Casa casa3 = new Casa("Peron", 100, "San Justo", 60000.0, true, TipoDeOperacion.VENTA);

		inmobiliariaActual.aniadirPropiedad(casa1);
		inmobiliariaActual.aniadirPropiedad(casa2);
		inmobiliariaActual.aniadirPropiedad(casa3);
		ArrayList<Casa> casasOrdenadas = inmobiliariaActual.ordenarCasasPorLocalidad();

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

		inmobiliariaActual.aniadirPropiedad(casa1);
		inmobiliariaActual.aniadirPropiedad(casa2);
		inmobiliariaActual.aniadirPropiedad(casa3);
		ArrayList<Casa> casasEncontradas = inmobiliariaActual.buscarCasasPorLocalidad(localidadDeseada);

		assertFalse(casasEncontradas.isEmpty());
		assertEquals(cantidadCasasEncontradas, (Integer) casasEncontradas.size());
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

		inmobiliariaActual.aniadirPropiedad(casa1);
		inmobiliariaActual.aniadirPropiedad(casa2);
		inmobiliariaActual.aniadirPropiedad(casa3);
		ArrayList<Casa> casasEncontradas = inmobiliariaActual.buscarCasasPorLocalidad(localidadDeseada);

		assertFalse(casasEncontradas.isEmpty());
		assertEquals(cantidadCasasEncontradas, (Integer) casasEncontradas.size());
	}

	@Test
	public void queLaBusquedaPorRangoDePrecioDeMeArrojeUnaListaNoNuloSiAplicanResultados() {
		Integer cantidadCasasEncontradas = 2;
		Double precioMinimo = 55000.0;
		Double precioMaximo = 150000.0;
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Casa casa1 = new Casa("Alberdi", 640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA);
		Casa casa2 = new Casa("Gaona", 500, "Haedo", 100000.0, true, TipoDeOperacion.VENTA);
		Casa casa3 = new Casa("Peron", 100, "San Justo", 60000.0, true, TipoDeOperacion.VENTA);

		inmobiliariaActual.aniadirPropiedad(casa1);
		inmobiliariaActual.aniadirPropiedad(casa2);
		inmobiliariaActual.aniadirPropiedad(casa3);
		LinkedList<Casa> casasEncontradas = inmobiliariaActual.buscarCasasPorRangoDePrecio(precioMinimo, precioMaximo);

		assertNotNull(casasEncontradas);
		assertEquals(cantidadCasasEncontradas, (Integer) casasEncontradas.size());
	}

	@Test
	public void queLaBusquedaPorRangoDePrecioDeCasasMeArrojeUnaListaNuloSiNoAplicanResultados() {
		Double precioMinimo = 10000.0;
		Double precioMaximo = 40000.0;
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Casa casa1 = new Casa("Alberdi", 640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA);
		Casa casa2 = new Casa("Gaona", 500, "Haedo", 100000.0, true, TipoDeOperacion.VENTA);
		Casa casa3 = new Casa("Peron", 100, "San Justo", 60000.0, true, TipoDeOperacion.VENTA);

		inmobiliariaActual.aniadirPropiedad(casa1);
		inmobiliariaActual.aniadirPropiedad(casa2);
		inmobiliariaActual.aniadirPropiedad(casa3);

		LinkedList<Casa> casasEncontradas = inmobiliariaActual.buscarCasasPorRangoDePrecio(precioMinimo, precioMaximo);

		assertNull(casasEncontradas);
	}

	@Test
	public void queLaBusquedaDePropiedadesPorVentaMeArrojeUnaLista() {
		Integer cantidadCasasEncontradas = 2;
		TipoDeOperacion operacionDeseada = TipoDeOperacion.VENTA;
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Casa casa1 = new Casa("Alberdi", 640, "Haedo", 50000.0, true, TipoDeOperacion.ALQUILER);
		Casa casa2 = new Casa("Gaona", 500, "Haedo", 100000.0, true, TipoDeOperacion.VENTA);
		Casa casa3 = new Casa("Peron", 100, "San Justo", 60000.0, true, TipoDeOperacion.VENTA);

		inmobiliariaActual.aniadirPropiedad(casa1);
		inmobiliariaActual.aniadirPropiedad(casa2);
		inmobiliariaActual.aniadirPropiedad(casa3);
		ArrayList<Casa> casasEncontradas = inmobiliariaActual.buscarCasasPorOperacion(operacionDeseada);

		assertNotNull(casasEncontradas);
		assertEquals(cantidadCasasEncontradas, (Integer) casasEncontradas.size());
	}

	@Test
	public void queLaBusquedaDePropiedadesPorVentaMeArrojeUnaListaNuloSiNoAplicanResultados() {
		TipoDeOperacion operacionDeseada = TipoDeOperacion.VENTA;
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Casa casa1 = new Casa("Alberdi", 640, "Haedo", 50000.0, true, TipoDeOperacion.ALQUILER);
		Casa casa2 = new Casa("Gaona", 500, "Haedo", 100000.0, true, TipoDeOperacion.ALQUILER);
		Casa casa3 = new Casa("Peron", 100, "San Justo", 60000.0, true, TipoDeOperacion.ALQUILER);

		inmobiliariaActual.aniadirPropiedad(casa1);
		inmobiliariaActual.aniadirPropiedad(casa2);
		inmobiliariaActual.aniadirPropiedad(casa3);
		ArrayList<Casa> casasEncontradas = inmobiliariaActual.buscarCasasPorOperacion(operacionDeseada);

		assertNull(casasEncontradas);

	}
}
