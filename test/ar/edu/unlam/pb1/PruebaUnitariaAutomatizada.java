package ar.edu.unlam.pb1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PruebaUnitariaAutomatizada {

	// según mi lógica de negocio aquellos clientes que poseen
	// una propiedad que registrarán en la Inmobiliaria deben ser registrados
	// previamente
	@Test
	public void queSePuedaDarDeAltaUnaCasaEnLaInmobiliaria() throws UmbralMinimoNoAlcanzadoException {
		final Integer DIMENSION_DEL_ARRAY_ESPERADA = 1;
		TiposDePropiedades tipoDePropiedadEsperada = TiposDePropiedades.CASA;
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Cliente propietario = new Cliente(11222333, "Pedro", "Martinez", false);
		Propiedad casa = new Casa("Alberdi", 640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA, propietario);

		inmobiliariaActual.aniadirCliente(propietario);
		inmobiliariaActual.aniadirPropiedad(casa);
		TiposDePropiedades tipoPropiedadObtenida = casa.getTipoDePropiedad();

		assertEquals(DIMENSION_DEL_ARRAY_ESPERADA, (Integer) inmobiliariaActual.getPropiedades().size());
		assertEquals(tipoDePropiedadEsperada, tipoPropiedadObtenida);
	}

	@Test
	public void queSePuedaDarDeAltaDosCasasEnLaInmobiliaria() throws UmbralMinimoNoAlcanzadoException {
		final Integer DIMENSION_DEL_ARRAY_ESPERADA = 2;
		TiposDePropiedades tipoDePropiedadEsperada = TiposDePropiedades.CASA;
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Cliente propietario = new Cliente(11222333, "Pedro", "Martinez", false);
		Propiedad casa = new Casa("Alberdi", 640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA, propietario);
		Propiedad casa2 = new Casa("Gaona", 500, "Ramos", 100000.0, true, TipoDeOperacion.VENTA, propietario);

		inmobiliariaActual.aniadirCliente(propietario);
		inmobiliariaActual.aniadirPropiedad(casa);
		inmobiliariaActual.aniadirPropiedad(casa2);
		TiposDePropiedades tipoPropiedadObtenida1 = casa.getTipoDePropiedad();
		TiposDePropiedades tipoPropiedadObtenida2 = casa2.getTipoDePropiedad();

		assertEquals(DIMENSION_DEL_ARRAY_ESPERADA, (Integer) inmobiliariaActual.getPropiedades().size());
		assertEquals(tipoDePropiedadEsperada, tipoPropiedadObtenida1);
		assertEquals(tipoDePropiedadEsperada, tipoPropiedadObtenida2);
	}

	@Test
	public void queSePuedaDarDeAltaUnDepartamentoEnLaInmobiliaria() throws UmbralMinimoNoAlcanzadoException {
		final Integer DIMENSION_DEL_ARRAY_ESPERADA = 1;
		TiposDePropiedades tipoDePropiedadEsperada = TiposDePropiedades.DEPARTAMENTO;
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Cliente propietario = new Cliente(11222333, "Pedro", "Martinez", false);
		Propiedad departamento = new Departamento("Alberdi", 640, "Haedo", 2, 'D', 25000.0, true,
				TipoDeOperacion.ALQUILER, propietario);

		inmobiliariaActual.aniadirCliente(propietario);
		inmobiliariaActual.aniadirPropiedad(departamento);
		TiposDePropiedades tipoPropiedadObtenida = departamento.getTipoDePropiedad();

		assertEquals(DIMENSION_DEL_ARRAY_ESPERADA, (Integer) inmobiliariaActual.getPropiedades().size());
		assertEquals(tipoDePropiedadEsperada, tipoPropiedadObtenida);
	}

	@Test
	public void queSePuedaDarDeAltaDosDepartamentosEnLaInmobiliaria() throws UmbralMinimoNoAlcanzadoException {
		final Integer DIMENSION_DEL_ARRAY_ESPERADA = 2;
		TiposDePropiedades tipoDePropiedadEsperada = TiposDePropiedades.DEPARTAMENTO;
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Cliente propietario = new Cliente(11222333, "Pedro", "Martinez", false);
		Cliente propietario2 = new Cliente(14444555, "Maria", "Sanchez", false);
		Propiedad departamento = new Departamento("Alberdi", 640, "Haedo", 2, 'D', 25000.0, true,
				TipoDeOperacion.ALQUILER, propietario);
		Propiedad departamento2 = new Departamento("Mosconi", 1200, "Lomas del Mirador", 4, 'A', 30000.0, true,
				TipoDeOperacion.VENTA, propietario);

		inmobiliariaActual.aniadirCliente(propietario);
		inmobiliariaActual.aniadirCliente(propietario2);
		inmobiliariaActual.aniadirPropiedad(departamento);
		inmobiliariaActual.aniadirPropiedad(departamento2);
		TiposDePropiedades tipoPropiedadObtenida1 = departamento.getTipoDePropiedad();
		TiposDePropiedades tipoPropiedadObtenida2 = departamento2.getTipoDePropiedad();

		assertEquals(DIMENSION_DEL_ARRAY_ESPERADA, (Integer) inmobiliariaActual.getPropiedades().size());
		assertEquals(tipoDePropiedadEsperada, tipoPropiedadObtenida1);
		assertEquals(tipoDePropiedadEsperada, tipoPropiedadObtenida2);
	}

	@Test
	public void queSePuedaObtenerElValorPromedioUnicamenteDeLasCasas() throws UmbralMinimoNoAlcanzadoException {
		TiposDePropiedades tipoDePropiedadAPromediar = TiposDePropiedades.CASA;
		Double promedioDeLasCasasEsperado = 75000.0;
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Cliente propietario = new Cliente(11222333, "Pedro", "Martinez", false);
		Propiedad casa = new Casa("Alberdi", 640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA, propietario);
		Propiedad casa2 = new Casa("Gaona", 500, "Ramos", 100000.0, true, TipoDeOperacion.VENTA, propietario);
		Propiedad departamento = new Departamento("Alberdi", 640, "Haedo", 2, 'D', 25000.0, true,
				TipoDeOperacion.ALQUILER, propietario);

		inmobiliariaActual.aniadirCliente(propietario);
		inmobiliariaActual.aniadirPropiedad(casa);
		inmobiliariaActual.aniadirPropiedad(casa2);
		inmobiliariaActual.aniadirPropiedad(departamento);
		Double promedioDeLasCasasObtenido = inmobiliariaActual.calcularPromedioPrecio(tipoDePropiedadAPromediar);

		assertEquals(promedioDeLasCasasEsperado, promedioDeLasCasasObtenido, 0.1);
	}

	@Test
	public void queSePuedaObtenerElValorPromedioUnicamenteDeLosDepartamentos() throws UmbralMinimoNoAlcanzadoException {
		TiposDePropiedades tipoDePropiedadAPromediar = TiposDePropiedades.DEPARTAMENTO;
		Double promedioDeLosDepartamentosEsperado = 27500.0;
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Cliente propietario = new Cliente(11222333, "Pedro", "Martinez", false);
		Propiedad departamento = new Departamento("Alberdi", 640, "Haedo", 2, 'D', 25000.0, true,
				TipoDeOperacion.ALQUILER, propietario);
		Propiedad departamento2 = new Departamento("Mosconi", 1200, "Lomas del Mirador", 4, 'A', 30000.0, true,
				TipoDeOperacion.VENTA, propietario);
		Propiedad casa = new Casa("Alberdi", 640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA, propietario);

		inmobiliariaActual.aniadirCliente(propietario);
		inmobiliariaActual.aniadirPropiedad(departamento);
		inmobiliariaActual.aniadirPropiedad(departamento2);
		inmobiliariaActual.aniadirPropiedad(casa);
		Double promedioDeLosDepartamentosObtenido = inmobiliariaActual
				.calcularPromedioPrecio(tipoDePropiedadAPromediar);

		assertEquals(promedioDeLosDepartamentosEsperado, promedioDeLosDepartamentosObtenido, 0.1);
	}

	@Test
	public void queSePuedaObtenerElValorPromedioDeTodasLasPropiedades() throws UmbralMinimoNoAlcanzadoException {
		Double promedioEsperado = 51250.0;
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Cliente propietario = new Cliente(11222333, "Pedro", "Martinez", false);
		Propiedad departamento = new Departamento("Alberdi", 640, "Haedo", 2, 'D', 25000.0, true,
				TipoDeOperacion.ALQUILER, propietario);
		Propiedad departamento2 = new Departamento("Mosconi", 1200, "Lomas del Mirador", 4, 'A', 30000.0, true,
				TipoDeOperacion.VENTA, propietario);
		Propiedad casa = new Casa("Alberdi", 640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA, propietario);
		Propiedad terreno = new Terreno("Gaona", 500, "Ramos", 10.0, 100000.0, true, TipoDeOperacion.VENTA,
				propietario);

		inmobiliariaActual.aniadirCliente(propietario);
		inmobiliariaActual.aniadirPropiedad(departamento);
		inmobiliariaActual.aniadirPropiedad(departamento2);
		inmobiliariaActual.aniadirPropiedad(casa);
		inmobiliariaActual.aniadirPropiedad(terreno);
		Double promedioObtenido = inmobiliariaActual.calcularPromedioPrecio();

		assertEquals(promedioEsperado, promedioObtenido, 0.1);
	}

	@Test
	public void queSePuedaAgregarUnClienteALaInmobiliaria() {
		final Integer DIMENSION_DEL_ARRAY_ESPERADA = 1;
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Cliente cliente1 = new Cliente(123, "Pablo", "Rodriguez", false);

		inmobiliariaActual.aniadirCliente(cliente1);

		assertEquals(DIMENSION_DEL_ARRAY_ESPERADA, (Integer) inmobiliariaActual.getClientes().size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void queNoSePuedaAgregarUnClienteConDNINulo() {
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Cliente clienteConDNINulo = new Cliente(null, "Pablo", "Rodriguez", false);

		inmobiliariaActual.aniadirCliente(clienteConDNINulo);
	}

	@Test
	public void queNoSePuedaAgregarDosClientesConIgualDNI() {
		final Integer DIMENSION_DEL_ARRAY_ESPERADA = 1;

		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Cliente cliente1 = new Cliente(123, "Pablo", "Rodriguez", false);
		Cliente cliente2 = new Cliente(123, "Miriam", "Martinez", false);

		inmobiliariaActual.aniadirCliente(cliente1);
		inmobiliariaActual.aniadirCliente(cliente2);

		assertEquals(DIMENSION_DEL_ARRAY_ESPERADA, (Integer) inmobiliariaActual.getClientes().size());
	}

	@Test
	public void queSiAgregoTresClientesConDosClientesRepetidosLaDimensionDelArraySeaDos() {
		final Integer DIMENSION_DEL_ARRAY_ESPERADA = 2;

		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Cliente cliente1 = new Cliente(123, "Pablo", "Rodriguez", false);
		Cliente cliente2 = new Cliente(122, "Diego", "Diaz", false);

		inmobiliariaActual.aniadirCliente(cliente1);
		inmobiliariaActual.aniadirCliente(cliente2);
		inmobiliariaActual.aniadirCliente(cliente2);

		assertEquals(DIMENSION_DEL_ARRAY_ESPERADA, (Integer) inmobiliariaActual.getClientes().size());
	}

	@Test
	public void queSePuedaRealizarLaVentaDeUnaPropiedad()
			throws PropiedadNoDisponibleException, ClienteNoRegistradoException, PropiedadNoRegistradaException, UmbralMinimoNoAlcanzadoException {
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Cliente propietario = new Cliente(11222333, "Pedro", "Martinez", false);
		Cliente comprador = new Cliente(77777888, "Sofia", "Ramos", false);
		Propiedad departamento = new Departamento("Alberdi", 640, "Haedo", 2, 'D', 25000.0, true, TipoDeOperacion.VENTA,
				propietario);

		inmobiliariaActual.aniadirCliente(comprador);
		inmobiliariaActual.aniadirCliente(propietario);
		inmobiliariaActual.aniadirPropiedad(departamento);
		inmobiliariaActual.venderPropiedad(departamento, comprador);

		assertEquals(comprador, departamento.getPropietario());
		assertFalse(departamento.getEstaDisponible());
		assertTrue(comprador.getPropiedadesCompradas().contains(departamento));
	}

	@Test(expected = ClienteNoRegistradoException.class)
	public void queNoSePuedaRealizarLaVentaDeUnaPropiedadSiElCompradorNoEstaRegistrado()
			throws PropiedadNoDisponibleException, ClienteNoRegistradoException, PropiedadNoRegistradaException, UmbralMinimoNoAlcanzadoException {
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Cliente propietario = new Cliente(11222333, "Pedro", "Martinez", false);
		Cliente comprador = new Cliente(77777888, "Sofia", "Ramos", false);
		Propiedad departamento = new Departamento("Alberdi", 640, "Haedo", 2, 'D', 25000.0, true, TipoDeOperacion.VENTA,
				propietario);

		inmobiliariaActual.aniadirCliente(propietario);
		inmobiliariaActual.aniadirPropiedad(departamento);
		inmobiliariaActual.venderPropiedad(departamento, comprador);
	}

	@Test(expected = PropiedadNoDisponibleException.class)
	public void queNoSePuedaRealizarLaVentaDeUnaPropiedadSiEstaDisponibleParaAlquiler()
			throws PropiedadNoDisponibleException, ClienteNoRegistradoException, PropiedadNoRegistradaException, UmbralMinimoNoAlcanzadoException {
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Cliente propietario = new Cliente(11222333, "Pedro", "Martinez", false);
		Cliente comprador = new Cliente(77777888, "Sofia", "Ramos", false);
		Propiedad departamento = new Departamento("Alberdi", 640, "Haedo", 2, 'D', 25000.0, true,
				TipoDeOperacion.ALQUILER, propietario);

		inmobiliariaActual.aniadirCliente(comprador);
		inmobiliariaActual.aniadirCliente(propietario);
		inmobiliariaActual.aniadirPropiedad(departamento);
		inmobiliariaActual.venderPropiedad(departamento, comprador);
	}

	@Test(expected = PropiedadNoRegistradaException.class)
	public void queNoSePuedaRealizarLaVentaDeUnaPropiedadSiNoEstaRegistrada()
			throws PropiedadNoDisponibleException, ClienteNoRegistradoException, PropiedadNoRegistradaException {
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Cliente propietario = new Cliente(11222333, "Pedro", "Martinez", false);
		Cliente comprador = new Cliente(77777888, "Sofia", "Ramos", false);
		Propiedad departamento = new Departamento("Alberdi", 640, "Haedo", 2, 'D', 25000.0, true, TipoDeOperacion.VENTA,
				propietario);

		inmobiliariaActual.aniadirCliente(comprador);
		inmobiliariaActual.aniadirCliente(propietario);
		inmobiliariaActual.venderPropiedad(departamento, comprador);
	}

	@Test
	public void queSePuedaRealizarElAlquilerDeUnaPropiedad()
			throws PropiedadNoDisponibleException, ClienteNoRegistradoException, PropiedadNoRegistradaException, UmbralMinimoNoAlcanzadoException {
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Cliente propietario = new Cliente(11222333, "Pedro", "Martinez", false);
		Cliente inquilino = new Cliente(77777888, "Sofia", "Ramos", false);
		Propiedad departamento = new Departamento("Alberdi", 640, "Haedo", 2, 'D', 25000.0, true,
				TipoDeOperacion.ALQUILER, propietario);

		inmobiliariaActual.aniadirCliente(inquilino);
		inmobiliariaActual.aniadirCliente(propietario);
		inmobiliariaActual.aniadirPropiedad(departamento);
		inmobiliariaActual.alquilarPropiedad(departamento, inquilino);

		assertEquals(propietario, departamento.getPropietario());
		assertEquals(inquilino, departamento.getInquilino());
		assertFalse(departamento.getEstaDisponible());
		assertTrue(inquilino.getPropiedadesAlquiladas().contains(departamento));
	}

	@Test(expected = ClienteNoRegistradoException.class)
	public void queNoSePuedaRealizarElAlquilerDeUnaPropiedadSiElCompradorNoEstaRegistrado()
			throws PropiedadNoDisponibleException, ClienteNoRegistradoException, PropiedadNoRegistradaException, UmbralMinimoNoAlcanzadoException {
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Cliente propietario = new Cliente(11222333, "Pedro", "Martinez", false);
		Cliente inquilino = new Cliente(77777888, "Sofia", "Ramos", false);
		Propiedad departamento = new Departamento("Alberdi", 640, "Haedo", 2, 'D', 25000.0, true,
				TipoDeOperacion.ALQUILER, propietario);

		inmobiliariaActual.aniadirCliente(propietario);
		inmobiliariaActual.aniadirPropiedad(departamento);
		inmobiliariaActual.alquilarPropiedad(departamento, inquilino);
	}

	@Test(expected = PropiedadNoRegistradaException.class)
	public void queNoSePuedaRealizarElAlquilerDeUnaPropiedadSiNoEstaRegistrada()
			throws PropiedadNoDisponibleException, ClienteNoRegistradoException, PropiedadNoRegistradaException {
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Cliente propietario = new Cliente(11222333, "Pedro", "Martinez", false);
		Cliente comprador = new Cliente(77777888, "Sofia", "Ramos", false);
		Propiedad departamento = new Departamento("Alberdi", 640, "Haedo", 2, 'D', 25000.0, true,
				TipoDeOperacion.ALQUILER, propietario);

		inmobiliariaActual.aniadirCliente(comprador);
		inmobiliariaActual.aniadirCliente(propietario);
		inmobiliariaActual.venderPropiedad(departamento, comprador);
	}

	@Test
	public void queSePuedaRealizarLaPermutaDeDosPropiedades()
			throws PropiedadNoDisponibleException, ClienteNoRegistradoException, PropiedadNoRegistradaException, UmbralMinimoNoAlcanzadoException {
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Cliente propietario1 = new Cliente(11222333, "Pedro", "Martinez", false);
		Cliente propietario2 = new Cliente(77777888, "Sofia", "Ramos", false);
		Propiedad casa1 = new Casa("Alberdi", 640, "Haedo", 25000.0, true, TipoDeOperacion.PERMUTA, propietario1);
		Propiedad casa2 = new Casa("Alberdi", 640, "Haedo", 25000.0, true, TipoDeOperacion.PERMUTA, propietario2);

		inmobiliariaActual.aniadirCliente(propietario1);
		inmobiliariaActual.aniadirCliente(propietario2);
		inmobiliariaActual.aniadirPropiedad(casa1);
		inmobiliariaActual.aniadirPropiedad(casa2);
		inmobiliariaActual.permutarPropiedades(casa1, casa2, propietario1, propietario2);

		assertEquals(propietario2, casa1.getPropietario());
		assertEquals(propietario1, casa2.getPropietario());
		assertFalse(casa1.getEstaDisponible());
		assertFalse(casa2.getEstaDisponible());
	}

	@Test(expected = ClienteNoRegistradoException.class)
	public void queNoSePuedaRealizarLaPermutaDeDosPropiedadesSiAlgunClienteNoEstaRegistrado()
			throws PropiedadNoDisponibleException, ClienteNoRegistradoException, PropiedadNoRegistradaException, UmbralMinimoNoAlcanzadoException {
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Cliente propietario1 = new Cliente(11222333, "Pedro", "Martinez", false);
		Cliente propietario2 = new Cliente(77777888, "Sofia", "Ramos", false);
		Propiedad casa1 = new Casa("Alberdi", 640, "Haedo", 25000.0, true, TipoDeOperacion.PERMUTA, propietario1);
		Propiedad casa2 = new Casa("Alberdi", 640, "Haedo", 25000.0, true, TipoDeOperacion.PERMUTA, propietario2);

		inmobiliariaActual.aniadirCliente(propietario1);
		inmobiliariaActual.aniadirPropiedad(casa1);
		inmobiliariaActual.aniadirPropiedad(casa2);
		inmobiliariaActual.permutarPropiedades(casa1, casa2, propietario1, propietario2);
	}

	@Test(expected = PropiedadNoRegistradaException.class)
	public void queNoSePuedaRealizarLaPermutaDeDosPropiedadesSiAlgunaNoEstaRegistrada()
			throws PropiedadNoDisponibleException, ClienteNoRegistradoException, PropiedadNoRegistradaException, UmbralMinimoNoAlcanzadoException {
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Cliente propietario1 = new Cliente(11222333, "Pedro", "Martinez", false);
		Cliente propietario2 = new Cliente(77777888, "Sofia", "Ramos", false);
		Propiedad casa1 = new Casa("Alberdi", 640, "Haedo", 25000.0, true, TipoDeOperacion.PERMUTA, propietario1);
		Propiedad casa2 = new Casa("Alberdi", 640, "Haedo", 25000.0, true, TipoDeOperacion.PERMUTA, propietario2);

		inmobiliariaActual.aniadirCliente(propietario1);
		inmobiliariaActual.aniadirCliente(propietario2);
		inmobiliariaActual.aniadirPropiedad(casa2);
		inmobiliariaActual.permutarPropiedades(casa1, casa2, propietario1, propietario2);
	}

	@Test
	public void queSePuedaRealizarLaBusquedaDeCasasPorRangoDePreciosYElResultadoEsteOrdenadoPorPrecio() throws SinResultadosException, UmbralMinimoNoAlcanzadoException {
		Double precioMinimo = 20000.0;
		Double precioMaximo = 60000.0;

		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com", 1122334455);
		Cliente propietario = new Cliente(11222333, "Pedro", "Martinez", false);
		Propiedad casa1 = new Casa("Alberdi", 640, "Haedo", 20000.0, true, TipoDeOperacion.VENTA, propietario);
		Propiedad casa2 = new Casa("Rivadavia", 123, "Moron", 30000.0, true, TipoDeOperacion.VENTA, propietario);
		Propiedad casa3 = new Casa("Gaona", 456, "Ramos Mejia", 65000.0, true, TipoDeOperacion.VENTA, propietario);
		
		inmobiliariaActual.aniadirCliente(propietario);
		inmobiliariaActual.aniadirPropiedad(casa1);
		inmobiliariaActual.aniadirPropiedad(casa2);
		inmobiliariaActual.aniadirPropiedad(casa3);

		TreeSet<Propiedad> propiedadesDentroDeRango = inmobiliariaActual.buscarPropiedadesPorRangoDePrecio(precioMinimo, precioMaximo);

		assertEquals(casa1, propiedadesDentroDeRango.first());
	    assertTrue(propiedadesDentroDeRango.contains(casa1));
	    assertTrue(propiedadesDentroDeRango.contains(casa2));
	    assertFalse(propiedadesDentroDeRango.contains(casa3));
	}

	@Test
	public void queSePuedaRealizarLaBusquedaDeCasasPorUbicacionYElResultadoEsteOrdenadoPorUbicacion() throws SinResultadosException, UmbralMinimoNoAlcanzadoException {
		String localidadBuscada = "MORON";

		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com", 1122334455);
		Cliente propietario = new Cliente(11222333, "Pedro", "Martinez", false);
		Propiedad casa1 = new Casa("Alberdi", 640, "Mataderos", 100000.0, true, TipoDeOperacion.VENTA, propietario);
		Propiedad casa2 = new Casa("Rivadavia", 123, "Moron", 30000.0, true, TipoDeOperacion.VENTA, propietario);
		Propiedad casa3 = new Casa("Gaona", 456, "Moron", 65000.0, true, TipoDeOperacion.VENTA, propietario);
		
		inmobiliariaActual.aniadirCliente(propietario);
		inmobiliariaActual.aniadirPropiedad(casa1);
		inmobiliariaActual.aniadirPropiedad(casa2);
		inmobiliariaActual.aniadirPropiedad(casa3);

		TreeSet<Propiedad> propiedadesEncontradas = inmobiliariaActual.buscarPropiedadesPorLocalidad(localidadBuscada.toLowerCase());

		assertTrue(propiedadesEncontradas.contains(casa2));
	    assertTrue(propiedadesEncontradas.contains(casa3));
	    assertFalse(propiedadesEncontradas.contains(casa1));
	}

	@Test
	public void queSePuedaRealizarLaBusquedaDeDepartamentosPorRangoDePreciosYElResultadoEsteOrdenadoPorPrecio() throws SinResultadosException, UmbralMinimoNoAlcanzadoException {
		Double precioMinimo = 20000.0;
		Double precioMaximo = 60000.0;

		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com", 1122334455);
		Cliente propietario = new Cliente(11222333, "Pedro", "Martinez", false);
		Propiedad departamento = new Departamento("Alberdi", 640, "Haedo", 2, 'D', 25000.0, true,
				TipoDeOperacion.ALQUILER, propietario);
		Propiedad departamento2 = new Departamento("Alberdi", 640, "Haedo", 2, 'D', 50000.0, true,
				TipoDeOperacion.ALQUILER, propietario);
		Propiedad departamento3 = new Departamento("Alberdi", 640, "Haedo", 2, 'D', 61000.0, true,
				TipoDeOperacion.ALQUILER, propietario);
		
		inmobiliariaActual.aniadirCliente(propietario);
		inmobiliariaActual.aniadirPropiedad(departamento);
		inmobiliariaActual.aniadirPropiedad(departamento2);
		inmobiliariaActual.aniadirPropiedad(departamento3);

		TreeSet<Propiedad> propiedadesDentroDeRango = inmobiliariaActual.buscarPropiedadesPorRangoDePrecio(precioMinimo, precioMaximo);

		assertEquals(departamento, propiedadesDentroDeRango.first());
	    assertTrue(propiedadesDentroDeRango.contains(departamento2));
	    assertFalse(propiedadesDentroDeRango.contains(departamento3));
	}

	@Test
	public void queSePuedaRealizarLaBusquedaDeDepartamentosPorUbicacionYElResultadoEsteOrdenadoPorUbicacion() throws SinResultadosException, UmbralMinimoNoAlcanzadoException {
		String localidadBuscada = "TABlada";

		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com", 1122334455);
		Cliente propietario = new Cliente(11222333, "Pedro", "Martinez", false);
		Propiedad departamento = new Departamento("Alberdi", 640, "Mataderos", 2, 'D', 25000.0, true,
				TipoDeOperacion.ALQUILER, propietario);
		Propiedad departamento2 = new Departamento("Rivadavia", 510, "Liniers", 2, 'D', 50000.0, true,
				TipoDeOperacion.ALQUILER, propietario);
		Propiedad departamento3 = new Departamento("Gascon", 640, "Tablada", 2, 'D', 61000.0, true,
				TipoDeOperacion.ALQUILER, propietario);
		
		inmobiliariaActual.aniadirCliente(propietario);
		inmobiliariaActual.aniadirPropiedad(departamento);
		inmobiliariaActual.aniadirPropiedad(departamento2);
		inmobiliariaActual.aniadirPropiedad(departamento3);

		TreeSet<Propiedad> propiedadesEncontradas = inmobiliariaActual.buscarPropiedadesPorLocalidad(localidadBuscada.toLowerCase());

		assertEquals(departamento3, propiedadesEncontradas.first());
	    assertFalse(propiedadesEncontradas.contains(departamento));
	    assertFalse(propiedadesEncontradas.contains(departamento2));
	}
	
	@Test(expected = SinResultadosException.class)
	public void queAlBuscarPorUnCriterioQueNoArrojeResultadosSeProduzcaLaExcepcionSinResultadosException() throws SinResultadosException {
		String localidadBuscada = "ramos mejia";
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com", 1122334455);

	    inmobiliariaActual.buscarPropiedadesPorLocalidad(localidadBuscada);
	}

	@Test(expected = UmbralMinimoNoAlcanzadoException.class)
	public void queAlIntentarGuardarUnaPropiedadParaLaVentaCuyoImporteEstaPorDebajoDelUmbral10000SeArrojeLaExcepcionUmbralMinimoNoAlcanzadoException() throws UmbralMinimoNoAlcanzadoException {
	    Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com", 1122334455);
	    Cliente propietario = new Cliente(11222333, "Pedro", "Martinez", false);
	    Propiedad propiedadBarata = new Casa("Alberdi", 640, "Haedo", 9000.0, true, TipoDeOperacion.VENTA, propietario);
	    
	    inmobiliariaActual.aniadirPropiedad(propiedadBarata);
	}
	
	@Test
	public void queSiNoTengoCasasElPrecioPromedioDeCero() {
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av. Rivadavia", "sandovalInmobiliaria@mail.com",
				1122334455);

		assertEquals(0.0, inmobiliariaActual.calcularPromedioPrecio(), 0.01);
	}

	@Test
	public void queSiUnaCasaEstaDisponibleElMetodoGetEstaDisponibilidadDeTrue() throws UmbralMinimoNoAlcanzadoException {
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Cliente propietario = new Cliente(11222333, "Pedro", "Martinez", false);
		Propiedad casa1 = new Casa("Alberdi", 640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA, propietario);

		inmobiliariaActual.aniadirPropiedad(casa1);

		assertTrue(casa1.getEstaDisponible());
	}

	@Test
	public void queSiUnaCasaEstaALaVentaDeTrueParaVentaYFalseParaAlquiler() throws UmbralMinimoNoAlcanzadoException {
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Cliente propietario = new Cliente(11222333, "Pedro", "Martinez", false);
		Propiedad casa1 = new Casa("Alberdi", 640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA, propietario);

		inmobiliariaActual.aniadirPropiedad(casa1);

		assertTrue(casa1.estaDisponiblePara(TipoDeOperacion.VENTA));
		assertFalse(casa1.estaDisponiblePara(TipoDeOperacion.ALQUILER));
	}

	@Test
	public void queSePuedanOrdenarLasCasasPorLocalidad() throws UmbralMinimoNoAlcanzadoException {
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Cliente propietario = new Cliente(11222333, "Pedro", "Martinez", false);
		Propiedad casa1 = new Casa("Alberdi", 640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA, propietario);
		Propiedad casa2 = new Casa("Gaona", 500, "Ramos", 100000.0, true, TipoDeOperacion.VENTA, propietario);
		Propiedad casa3 = new Casa("Peron", 100, "San Justo", 60000.0, true, TipoDeOperacion.VENTA, propietario);

		inmobiliariaActual.aniadirPropiedad(casa1);
		inmobiliariaActual.aniadirPropiedad(casa2);
		inmobiliariaActual.aniadirPropiedad(casa3);		
		TreeSet<Propiedad> propiedadesOrdenadas = inmobiliariaActual.ordenarPropiedadesPorLocalidad();
	    
		Propiedad[] ordenEsperada = { casa1, casa2, casa3 }; 

	    int i = 0;
	    for (Propiedad propiedad : propiedadesOrdenadas) {
	        assertEquals(ordenEsperada[i++], propiedad);
	    }
		assertEquals(casa1, propiedadesOrdenadas.first());

	}

	@Test
	public void queLaBusquedaPorRangoDePrecioDeMeArrojeUnaListaNoNuloSiAplicanResultados() throws UmbralMinimoNoAlcanzadoException, SinResultadosException {
		Integer cantidadCasasEncontradas = 2;
		Double precioMinimo = 55000.0;
		Double precioMaximo = 150000.0;
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av.Rivadavia", "sandoval@inmobiliaria.com",
				1122334455);
		Cliente propietario = new Cliente(11222333, "Pedro", "Martinez", false);
		Propiedad casa1 = new Casa("Alberdi", 640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA, propietario);
		Propiedad casa2 = new Casa("Gaona", 500, "Ramos", 100000.0, true, TipoDeOperacion.VENTA, propietario);
		Propiedad casa3 = new Casa("Peron", 100, "San Justo", 60000.0, true, TipoDeOperacion.VENTA, propietario);

		inmobiliariaActual.aniadirPropiedad(casa1);
		inmobiliariaActual.aniadirPropiedad(casa2);
		inmobiliariaActual.aniadirPropiedad(casa3);
		TreeSet<Propiedad> casasEncontradas = inmobiliariaActual.buscarPropiedadesPorRangoDePrecio(precioMinimo, precioMaximo);

		assertNotNull(casasEncontradas);
		assertEquals(cantidadCasasEncontradas, (Integer) casasEncontradas.size());
	}
}