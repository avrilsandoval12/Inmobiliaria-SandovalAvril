package ar.edu.unlam.pb1;

import java.util.Scanner;

import javax.print.CancelablePrintJob;

public class InterfazInmobiliaria {
	
	private static Inmobiliaria inmobiliariaActual = new Inmobiliaria("Sandoval", "Av. Rivadavia",
			"sandovalInmobiliaria@mail.com", 1122334455);

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		Integer opcionMenu = 0;
		Integer tipoPropiedad = 0;
		Integer datoAModificar = 0;

		do {
			opcionMenu = menuOpcionesInicio(teclado);
			switch (OpcionMenu.values()[opcionMenu - 1]) {
			case AGREGAR_PROPIEDAD:
				tipoPropiedad = menuPropiedades(teclado);
				agregarPropiedad(tipoPropiedad);
				break;
			case MODIFICAR_PROPIEDAD:
				System.out.println("\nCasas: \n" + inmobiliariaActual.mostrarCasas());
				System.out.println("\nDepartamentos: \n" + inmobiliariaActual.mostrarDepartamentos());
				System.out.println("\nPhs: \n" + inmobiliariaActual.mostrarPhs());
				System.out.println("\nTerrenos: \n" + inmobiliariaActual.mostrarTerrenos());
				System.out.println("\nCampos: \n" + inmobiliariaActual.mostrarCampos());
				System.out.println("\nIntroduce el código de la propiedad que deseas modificar:");
				String codigo = teclado.next();
				tipoPropiedad = menuPropiedades(teclado);
				datoAModificar = menuModificarPropiedad(teclado, tipoPropiedad);
				Object datoNuevo = solicitarDato(datoAModificar);
				buscarYModificarPropiedad(codigo, datoAModificar, datoNuevo);
				break;
			case AGREGAR_CLIENTE:
				agregarCliente();
				break;
			case OBTENER_LISTADO_POR_PRECIO:
				tipoPropiedad = menuOrdenarPropiedades(teclado);
				ordenarPropiedadesPorPrecio(tipoPropiedad);
			case OBTENER_LISTADO_POR_UBICACION:
				tipoPropiedad = menuOrdenarPropiedades(teclado);
				ordenarPropiedadesPorUbicacion(tipoPropiedad);
			case BUSCAR_PROPIEDAD_POR_PRECIO:
				tipoPropiedad = menuPropiedades(teclado);
				System.out.println("\nIntroduce el precio mínimo:");
				double precioMinimo = teclado.nextDouble();
				System.out.println("\nIntroduce el precio máximo:");
				double precioMaximo = teclado.nextDouble();
				buscarPropiedadesPorRangoDePrecio(tipoPropiedad, precioMinimo, precioMaximo);
				break;
			case BUSCAR_PROPIEDAD_POR_UBICACION:
				tipoPropiedad = menuPropiedades(teclado);
				System.out.println("\nIntroduce la localidad:");
				String localidadDeseada = teclado.next().toUpperCase();
				buscarPropiedadesPorLocalidad(tipoPropiedad, localidadDeseada);
				break;
			case REALIZAR_VENTA:
				System.out.println("\nIntroduce el DNI del comprador:");
				Integer dniComprador = teclado.nextInt();
				System.out.println("\nCasas: \n" + inmobiliariaActual.mostrarCasas());
				System.out.println("\nDepartamentos: \n" + inmobiliariaActual.mostrarDepartamentos());
				System.out.println("\nPhs: \n" + inmobiliariaActual.mostrarPhs());
				System.out.println("\nTerrenos: \n" + inmobiliariaActual.mostrarTerrenos());
				System.out.println("\nCampos: \n" + inmobiliariaActual.mostrarCampos());
				System.out.println("\nIntroduce el código de la propiedad que deseas comprar:");
				String codigoPropiedadAComprar = teclado.next();
				comprarPropiedad(dniComprador, codigoPropiedadAComprar);
				break;
			case REALIZAR_ALQUILER:
				break;
			case CALCULAR_EL_PRECIO_PROMEDIO_DE_LAS_CASAS:
				System.out.println(inmobiliariaActual.calcularPrecioPromedioDeCasas());
				break;
			case SALIR:
				Boolean volverAIngresar;
				System.out.println("\nEl sistema se ha cerrado correctamente.");
				System.out.println("\n¿Desea volver a ingresar? (true/false)");
				volverAIngresar = teclado.nextBoolean();

				if (volverAIngresar) {
					opcionMenu = 1;
				} else {
					opcionMenu = 10;
				}
				break;
			default:
				break;
			}
		} while (opcionMenu != 10);
	}

	private static void comprarPropiedad(Integer dniComprador, String codigoPropiedad) {
		Cliente comprador = inmobiliariaActual.buscarClienePorDni(dniComprador);
		if (comprador != null) {
			Casa casaAComprar = inmobiliariaActual.buscarCasaPorCodigo(codigoPropiedad);
			if (casaAComprar != null && casaAComprar.estaDisponiblePara(TipoDeOperacion.VENTA)) {
				comprador.comprarPropiedad(casaAComprar);
				System.out.println("La casa ha sido comprada con éxito.");
			} else {
				System.out.println("La propiedad no está disponible para la venta o no existe.");
			}
		} else {
			System.out.println("El DNI introducido no corresponde a ningún cliente registrado.");
		}
	}

	private static void buscarPropiedadesPorLocalidad(Integer tipoPropiedad, String localidadDeseada) {
		Scanner teclado = new Scanner(System.in);
		switch (tipoPropiedad) {
		case 1:
			System.out.println("\nCasas:");
			inmobiliariaActual.buscarCasasPorLocalidad(localidadDeseada);
			break;
		case 2:
			System.out.println("\nDepartamentos:");
			inmobiliariaActual.buscarDepartamentosPorLocalidad(localidadDeseada);
			break;
		case 3:
			System.out.println("\nPHs:");
			inmobiliariaActual.buscarPhsPorLocalidad(localidadDeseada);
			break;
		case 4:
			System.out.println("\nTerrenos:");
			inmobiliariaActual.buscarTerrenosPorLocalidad(localidadDeseada);
			break;
		case 5:
			System.out.println("\nCampos:");
			inmobiliariaActual.buscarCamposPorLocalidad(localidadDeseada);
			break;
		case 6:
			System.out.println("\nAún no podemos buscar todas las propiedades juntas y ordenadas.");
			System.out.println("Casas:");
			inmobiliariaActual.buscarCasasPorLocalidad(localidadDeseada);
			System.out.println("Departamentos:");
			inmobiliariaActual.buscarDepartamentosPorLocalidad(localidadDeseada);
			System.out.println("PHs:");
			inmobiliariaActual.buscarPhsPorLocalidad(localidadDeseada);
			System.out.println("Terrenos:");
			inmobiliariaActual.buscarTerrenosPorLocalidad(localidadDeseada);
			System.out.println("Campos:");
			inmobiliariaActual.buscarCamposPorLocalidad(localidadDeseada);
		}
		System.out.println("\n¿Deseas buscar en otra localidad? (true/false): ");
		Boolean buscarTipoPropiedad = teclado.nextBoolean();
		teclado.nextLine();

		if (buscarTipoPropiedad) {
			Integer tipoPropiedadABuscar = menuPropiedades(teclado);
			System.out.println("\nIntroduce la localidad:");
			String localidadNueva = teclado.next().toUpperCase();
			buscarPropiedadesPorLocalidad(tipoPropiedadABuscar, localidadNueva);
		}

	}

	private static void buscarPropiedadesPorRangoDePrecio(Integer tipoPropiedad, double precioMinimo,
			double precioMaximo) {
		Scanner teclado = new Scanner(System.in);
		switch (tipoPropiedad) {
		case 1:
			System.out.println("\nCasas:");
			inmobiliariaActual.buscarCasasPorRangoDePrecio(precioMinimo, precioMaximo);
			break;
		case 2:
			System.out.println("\nDepartamentos:");
			inmobiliariaActual.buscarDepartamentosPorRangoDePrecio(precioMinimo, precioMaximo);
			break;
		case 3:
			System.out.println("\nPHs:");
			inmobiliariaActual.buscarPhsPorRangoDePrecio(precioMinimo, precioMaximo);
			break;
		case 4:
			System.out.println("\nTerrenos:");
			inmobiliariaActual.buscarTerrenosPorRangoDePrecio(precioMinimo, precioMaximo);
			break;
		case 5:
			System.out.println("\nCampos:");
			inmobiliariaActual.buscarCamposPorRangoDePrecio(precioMinimo, precioMaximo);
			break;
		case 6:
			System.out.println("\nAún no podemos buscar todas las propiedades juntas y ordenadas.");
			System.out.println("Casas:");
			inmobiliariaActual.buscarCasasPorRangoDePrecio(precioMinimo, precioMaximo);
			System.out.println("Departamentos:");
			inmobiliariaActual.buscarDepartamentosPorRangoDePrecio(precioMinimo, precioMaximo);
			System.out.println("PHs:");
			inmobiliariaActual.buscarPhsPorRangoDePrecio(precioMinimo, precioMaximo);
			System.out.println("Terrenos:");
			inmobiliariaActual.buscarTerrenosPorRangoDePrecio(precioMinimo, precioMaximo);
			System.out.println("Campos:");
			inmobiliariaActual.buscarCamposPorRangoDePrecio(precioMinimo, precioMaximo);
		}
		System.out.println("\n¿Deseas buscar otro rango de precios? (true/false): ");
		Boolean buscarTipoPropiedad = teclado.nextBoolean();
		teclado.nextLine();

		if (buscarTipoPropiedad) {
			Integer tipoPropiedadABuscar = menuPropiedades(teclado);
			System.out.println("\nIntroduce el precio mínimo:");
			double precioMinimoNuevo = teclado.nextDouble();
			System.out.println("\nIntroduce el precio máximo:");
			double precioMaximoNuevo = teclado.nextDouble();
			buscarPropiedadesPorRangoDePrecio(tipoPropiedadABuscar, precioMinimoNuevo, precioMaximoNuevo);
		}

	}

	private static Integer menuOrdenarPropiedades(Scanner teclado) {
		Integer opcionSeleccionada;
		System.out.print("\nSeleccione el tipo de propiedad que desea ordenar:");
		System.out.print("\n1. Casa");
		System.out.print("\n2. Departamento");
		System.out.print("\n3. PH");
		System.out.print("\n4. Terreno");
		System.out.print("\n5. Campo");
		System.out.println("\n6. Todas las propiedades");

		opcionSeleccionada = teclado.nextInt();
		return opcionSeleccionada;
	}

	private static void ordenarPropiedadesPorUbicacion(Integer tipoPropiedad) {
		Scanner teclado = new Scanner(System.in);
		switch (tipoPropiedad) {
		case 1:
			System.out.println("\nCasas:");
			inmobiliariaActual.ordenarCasasPorLocalidad();
			break;
		case 2:
			System.out.println("\nDepartamentos:");
			inmobiliariaActual.ordenarDepartamentosPorLocalidad();
			break;
		case 3:
			System.out.println("\nPHs:");
			inmobiliariaActual.ordenarPhsPorLocalidad();
			break;
		case 4:
			System.out.println("\nTerrenos:");
			inmobiliariaActual.ordenarTerrenosPorLocalidad();
			break;
		case 5:
			System.out.println("\nCampos:");
			inmobiliariaActual.ordenarCamposPorLocalidad();
			break;
		case 6:
			System.out.println("\nAún no podemos ordenar todas las propiedades.");
		}
		System.out.println("\n¿Deseas ordenar otro tipo de propiedad? (true/false): ");
		Boolean ordenarOtroTipoPropiedad = teclado.nextBoolean();
		teclado.nextLine();

		if (ordenarOtroTipoPropiedad) {
			Integer tipoPropiedadAOrdenar = menuPropiedades(teclado);
			ordenarPropiedadesPorUbicacion(tipoPropiedadAOrdenar);
		}
	}

	private static void ordenarPropiedadesPorPrecio(Integer tipoPropiedad) {
		Scanner teclado = new Scanner(System.in);
		switch (tipoPropiedad) {
		case 1:
			System.out.println("\nCasas:");
			inmobiliariaActual.ordenarCasasPorPrecio();
			break;
		case 2:
			System.out.println("\nDepartamentos:");
			inmobiliariaActual.ordenarDepartamentosPorPrecio();
			break;
		case 3:
			System.out.println("\nPHs:");
			inmobiliariaActual.ordenarPhsPorPrecio();
			break;
		case 4:
			System.out.println("\nTerrenos:");
			inmobiliariaActual.ordenarTerrenosPorPrecio();
			break;
		case 5:
			System.out.println("\nCampos:");
			inmobiliariaActual.ordenarCamposPorPrecio();
			break;
		case 6:
			System.out.println("\nAún no podemos ordenar todas las propiedades.");
			System.out.println("Casas:");
			inmobiliariaActual.ordenarCasasPorPrecio();
			System.out.println("Departamentos:");
			inmobiliariaActual.ordenarDepartamentosPorPrecio();
			System.out.println("PHs:");
			inmobiliariaActual.ordenarPhsPorPrecio();
			System.out.println("Terrenos:");
			inmobiliariaActual.ordenarTerrenosPorPrecio();
			System.out.println("Campos:");
			inmobiliariaActual.ordenarCamposPorPrecio();
		}
		System.out.println("\n¿Deseas ordenar otro tipo de propiedad? (true/false): ");
		Boolean ordenarOtroTipoPropiedad = teclado.nextBoolean();
		teclado.nextLine();

		if (ordenarOtroTipoPropiedad) {
			Integer tipoPropiedadAOrdenar = menuPropiedades(teclado);
			ordenarPropiedadesPorPrecio(tipoPropiedadAOrdenar);
		}
	}

	private static void agregarCliente() {
		Scanner teclado = new Scanner(System.in);
		Boolean exito;
		Cliente clienteNuevo = pedirDatosAgregarCliente();
		exito = inmobiliariaActual.añadirCliente(clienteNuevo);
		if (exito) {
			System.out.println("\nCliente añadido con éxito");
		} else {
			System.out.println("\nNo se pudo añadir el cliente, el DNI ingresado ya está registrado.");
		}

		System.out.println("\n¿Deseas agregar otro cliente? (true/false): ");
		Boolean agregarOtroCliente = teclado.nextBoolean();
		teclado.nextLine();

		if (agregarOtroCliente) {
			agregarCliente();
		} else {

		}
	}

	private static Cliente pedirDatosAgregarCliente() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("\nIngrese los datos del nuevo cliente:");
		System.out.println("DNI: ");
		Integer dni = teclado.nextInt();
		System.out.println("\nNombre: ");
		String nombre = teclado.nextLine();
		teclado.nextLine();
		System.out.println("\nApellido: ");
		String apellido = teclado.nextLine();
		System.out.println("\nTipo de propiedad de interés (CASA, DEPARTAMENTO, PH, TERRENO, CAMPO)");
		TiposDePropiedades tipoDePropiedadDeInteres = TiposDePropiedades.valueOf(teclado.nextLine().toUpperCase());
		System.out.println("\n¿Posee una propiedad para poder permutar? (true/false): ");
		Boolean poseePropiedadParaPermuta = teclado.nextBoolean();
		teclado.nextLine();
		return new Cliente(dni, nombre, apellido, tipoDePropiedadDeInteres, poseePropiedadParaPermuta);
	}

	private static void buscarYModificarPropiedad(String codigo, Integer datoAModificar, Object dato) {
		String tipoPropiedad = codigo.replaceAll("\\d", "");

		switch (tipoPropiedad) {
		case "CS":
			Casa casa = inmobiliariaActual.buscarCasaPorCodigo(codigo);
			if (casa != null) {
				System.out.println("\nCasa encontrada: " + casa);
				inmobiliariaActual.modificarDatosCasa(casa, datoAModificar, dato);
			} else {
				System.out.println("No se encontró ninguna casa con el código proporcionado.");
			}
			break;
		case "D":
			Departamento departamento = inmobiliariaActual.buscarDepartamentoPorCodigo(codigo);
			if (departamento != null) {
				System.out.println("\nDepartamento encontrado: " + departamento);
				inmobiliariaActual.modificarDatosDepartamento(departamento, datoAModificar, dato);
			} else {
				System.out.println("No se encontró ningún departamento con el código proporcionado.");
			}
			break;
		case "PH":
			PH ph = inmobiliariaActual.buscarPhPorCodigo(codigo);
			if (ph != null) {
				System.out.println("\nPH encontrado: " + ph);
				inmobiliariaActual.modificarDatosPh(ph, datoAModificar, dato);
			} else {
				System.out.println("No se encontró ningún PH con el código proporcionado.");
			}
			break;
		case "T":
			Terreno terreno = inmobiliariaActual.buscarTerrenoPorCodigo(codigo);
			if (terreno != null) {
				System.out.println("\nTerreno encontrado: " + terreno);
				inmobiliariaActual.modificarDatosTerreno(terreno, datoAModificar, dato);
			} else {
				System.out.println("No se encontró ningún terreno con el código proporcionado.");
			}
			break;
		case "CMP":
			Campo campo = inmobiliariaActual.buscarCampoPorCodigo(codigo);
			if (campo != null) {
				System.out.println("\nCampo encontrado: " + campo);
				inmobiliariaActual.modificarDatosCampo(campo, datoAModificar, dato);
			} else {
				System.out.println("No se encontró ningún campo con el código proporcionado.");
			}
			break;
		default:
			break;
		}
	}

	private static void agregarPropiedad(Integer opcionAgregarPropiedad) {
		Scanner teclado = new Scanner(System.in);
		Boolean exito;
		switch (TiposDePropiedades.values()[opcionAgregarPropiedad - 1]) {
		case CASA:
			Casa casaNueva = pedirDatosAgregarCasa();
			exito = inmobiliariaActual.aniadirCasa(casaNueva);

			if (exito) {
				System.out.println("\nCasa añadida con éxito");
			} else {
				System.out.println("\nNo se pudo añadir la casa. Por favor, intente nuevamente.");
			}
			break;
		case DEPARTAMENTO:
			Departamento departamentoNuevo = pedirDatosAgregarDepartamento();
			exito = inmobiliariaActual.aniadirDepartamento(departamentoNuevo);

			if (exito) {
				System.out.println("\nDepartamento añadido con éxito");
			} else {
				System.out.println("\nNo se pudo añadir el departamento. Por favor, intente nuevamente.");
			}
			break;
		case PH:
			PH phNuevo = pedirDatosAgregarPH();
			exito = inmobiliariaActual.aniadirPH(phNuevo);

			if (exito) {
				System.out.println("\nPH añadido con éxito");
			} else {
				System.out.println("\nNo se pudo añadir el PH. Por favor, intente nuevamente.");
			}
			break;
		case TERRENO:
			Terreno terrenoNuevo = pedirDatosAgregarTerreno();
			exito = inmobiliariaActual.aniadirTerreno(terrenoNuevo);

			if (exito) {
				System.out.println("\nTerreno añadido con éxito");
			} else {
				System.out.println("\nNo se pudo añadir el terreno. Por favor, intente nuevamente.");
			}
			break;
		case CAMPO:
			Campo campoNuevo = pedirDatosAgregarCampo();
			exito = inmobiliariaActual.aniadirCampo(campoNuevo);

			if (exito) {
				System.out.println("\nCampo añadido con éxito");
			} else {
				System.out.println("\nNo se pudo añadir el campo. Por favor, intente nuevamente.");
			}
			break;
		}
		System.out.println("\n¿Deseas agregar otra propiedad? (true/false): ");
		Boolean agregarOtraPropiedad = teclado.nextBoolean();
		teclado.nextLine();

		if (agregarOtraPropiedad) {
			Integer tipoPropiedadAAgregar = menuPropiedades(teclado);
			agregarPropiedad(tipoPropiedadAAgregar);
		}
	}

	private static Campo pedirDatosAgregarCampo() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("\nIngrese los datos de la nueva propiedad:");
		System.out.println("\nCalle: ");
		String calle = teclado.nextLine().toUpperCase();
		System.out.println("\nNúmero: ");
		Integer numero = teclado.nextInt();
		System.out.println("\nLocalidad: ");
		String localidad = teclado.nextLine().toUpperCase();
		teclado.nextLine();
		System.out.println("\nMetros cuadrados del terreno: ");
		Double hectareas = teclado.nextDouble();
		teclado.nextLine();
		System.out.println("\nPrecio: ");
		Double precio = teclado.nextDouble();
		teclado.nextLine();
		System.out.println("\n¿Está disponible? (true/false): ");
		Boolean estaDisponible = teclado.nextBoolean();
		teclado.nextLine();
		System.out.println("\nTipo de operacion (VENTA, ALQUILER, PERMUTA: ");
		TipoDeOperacion tipoDeOperacion = TipoDeOperacion.valueOf(teclado.nextLine().toUpperCase());
		return new Campo(calle, localidad, hectareas, precio, estaDisponible, tipoDeOperacion, numero);
	}

	private static Terreno pedirDatosAgregarTerreno() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("\nIngrese los datos de la nueva propiedad:");
		System.out.println("\nCalle: ");
		String calle = teclado.nextLine().toUpperCase();
		System.out.println("\nNúmero: ");
		Integer numero = teclado.nextInt();
		System.out.println("\nLocalidad: ");
		String localidad = teclado.nextLine().toUpperCase();
		teclado.nextLine();
		System.out.println("\nMetros cuadrados del terreno: ");
		Double metrosCuadrados = teclado.nextDouble();
		teclado.nextLine();
		System.out.println("\nPrecio: ");
		Double precio = teclado.nextDouble();
		teclado.nextLine();
		System.out.println("\n¿Está disponible? (true/false): ");
		Boolean estaDisponible = teclado.nextBoolean();
		teclado.nextLine();
		System.out.println("\nTipo de operacion (VENTA, ALQUILER, PERMUTA: ");
		TipoDeOperacion tipoDeOperacion = TipoDeOperacion.valueOf(teclado.nextLine().toUpperCase());
		return new Terreno(calle, numero, localidad, metrosCuadrados, precio, estaDisponible, tipoDeOperacion);
	}

	private static PH pedirDatosAgregarPH() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("\nIngrese los datos de la nueva propiedad:");
		System.out.println("\nCalle: ");
		String calle = teclado.nextLine().toUpperCase();
		System.out.println("\nNúmero: ");
		Integer numero = teclado.nextInt();
		System.out.println("\nLocalidad: ");
		String localidad = teclado.nextLine().toUpperCase();
		teclado.nextLine();
		System.out.println("\nNúmero de ph: ");
		Integer numeroPH = teclado.nextInt();
		System.out.println("\nPrecio: ");
		Double precio = teclado.nextDouble();
		teclado.nextLine();
		System.out.println("\n¿Está disponible? (true/false): ");
		Boolean estaDisponible = teclado.nextBoolean();
		teclado.nextLine();
		System.out.println("\nTipo de operacion (VENTA, ALQUILER, PERMUTA: ");
		TipoDeOperacion tipoDeOperacion = TipoDeOperacion.valueOf(teclado.nextLine().toUpperCase());
		return new PH(calle, numero, localidad, numeroPH, precio, estaDisponible, tipoDeOperacion);
	}

	private static Departamento pedirDatosAgregarDepartamento() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("\nIngrese los datos de la nueva propiedad:");
		System.out.println("\nCalle: ");
		String calle = teclado.nextLine().toUpperCase();
		System.out.println("\nNúmero: ");
		Integer numero = teclado.nextInt();
		System.out.println("\nLocalidad: ");
		String localidad = teclado.nextLine().toUpperCase();
		teclado.nextLine();
		System.out.println("\nNúmero piso: ");
		Integer numeroPiso = teclado.nextInt();
		System.out.println("\nLetra del departamento:");
		Character letra = teclado.next().charAt(0);
		System.out.println("\nPrecio: ");
		Double precio = teclado.nextDouble();
		teclado.nextLine();
		System.out.println("\n¿Está disponible? (true/false): ");
		Boolean estaDisponible = teclado.nextBoolean();
		teclado.nextLine();
		System.out.println("\nTipo de operacion (VENTA, ALQUILER, PERMUTA: ");
		TipoDeOperacion tipoDeOperacion = TipoDeOperacion.valueOf(teclado.nextLine().toUpperCase());

		return new Departamento(calle, numero, localidad, numeroPiso, letra, precio, estaDisponible, tipoDeOperacion);
	}

	private static Casa pedirDatosAgregarCasa() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("\nIngrese los datos de la nueva propiedad:");
		System.out.println("\nCalle: ");
		String calle = teclado.nextLine().toUpperCase();
		System.out.println("\nNúmero: ");
		Integer numero = teclado.nextInt();
		System.out.println("\nLocalidad: ");
		String localidad = teclado.nextLine().toUpperCase();
		teclado.nextLine();
		System.out.println("\nPrecio: ");
		Double precio = teclado.nextDouble();
		teclado.nextLine();
		System.out.println("\n¿Está disponible? (true/false): ");
		Boolean estaDisponible = teclado.nextBoolean();
		teclado.nextLine();
		System.out.println("\nTipo de operacion (VENTA, ALQUILER, PERMUTA: ");
		TipoDeOperacion tipoDeOperacion = TipoDeOperacion.valueOf(teclado.nextLine().toUpperCase());

		return new Casa(calle, numero, localidad, precio, estaDisponible, tipoDeOperacion);
	}

	private static Integer menuOpcionesInicio(Scanner teclado) {
		Integer opcionSeleccionada;
		System.out.print("Menú de opciones");
		System.out.print("\n1. Agregar nuevas propiedades");
		System.out.print("\n2. Modificar propiedades existentes");
		System.out.print("\n3. Agregar clientes");
		System.out.print("\n4. Obtener listado de propiedades por precio");
		System.out.print("\n5. Obtener listado de propiedades por ubicación");
		System.out.print("\n6. Buscar propiedades por rango de precio");
		System.out.print("\n7. Buscar propiedades por ubicación");
		System.out.print("\n8. Realizar la venta de una propiedad");
		System.out.print("\n9. Realizar el alquiler de una propiedad");
		System.out.print("\n10. Salir");

		opcionSeleccionada = teclado.nextInt();
		return opcionSeleccionada;
	}

	private static Integer menuPropiedades(Scanner teclado) {
		Integer opcionSeleccionada;
		System.out.print("\nSeleccione el tipo de propiedad:");
		System.out.print("\n1. Casa");
		System.out.print("\n2. Departamento");
		System.out.print("\n3. PH");
		System.out.print("\n4. Terreno");
		System.out.print("\n5. Campo");

		opcionSeleccionada = teclado.nextInt();
		return opcionSeleccionada;
	}

	private static Integer menuModificarPropiedad(Scanner teclado, Integer tipoPropiedad) {
		Integer opcionSeleccionada;
		switch (tipoPropiedad) {
		case 1:
		case 2:
		case 3:
			System.out.println("Selecciona el dato que quieres modificar:");
			System.out.println("1. Calle");
			System.out.println("2. Número");
			System.out.println("3. Localidad");
			System.out.println("4. Precio");
			System.out.println("5. Disponibilidad");
			System.out.println("6. Tipo de operación");

			opcionSeleccionada = teclado.nextInt();
			return opcionSeleccionada;
		case 4:
			System.out.println("Selecciona el dato del terreno que quieres modificar:");
			System.out.println("\n1. Calle");
			System.out.println("\n2. Número");
			System.out.println("\n3. Localidad");
			System.out.println("\n4. Precio");
			System.out.println("\n5. Disponibilidad");
			System.out.println("\n6. Tipo de operación");
			System.out.println("\n7. Metros cuadrados");

			opcionSeleccionada = teclado.nextInt();
			return opcionSeleccionada;
		case 5:
			System.out.println("Selecciona el dato del departamento que quieres modificar:");
			System.out.println("\n1. Calle");
			System.out.println("\n2. Número");
			System.out.println("\n3. Localidad");
			System.out.println("\n4. Precio");
			System.out.println("\n5. Disponibilidad");
			System.out.println("\n6. Tipo de operación");
			System.out.println("\n8. Hectareas");

			opcionSeleccionada = teclado.nextInt();
			return opcionSeleccionada;

		default:
			System.out.println("La opción seleccionada no corresponde a ningun tipo de propiedad.");
			break;
		}
		return null;
	}

	private static Object solicitarDato(Integer datoAModificar) {
		Scanner teclado = new Scanner(System.in);
		switch (datoAModificar) {
		case 1:
			System.out.println("Ingrese el nuevo nombre de la calle:");
			return teclado.next().toUpperCase();
		case 2:
			System.out.println("Ingrese el nuevo número de la propiedad:");
			return teclado.nextInt();
		case 3:
			System.out.println("Ingrese el nuevo nombre de la localidad:");
			return teclado.next().toUpperCase();
		case 4:
			System.out.println("Ingrese el nuevo precio de la propiedad:");
			return teclado.nextDouble();
		case 5:
			System.out.println("Ingrese si la propiedad se encuentra disponible (true/false):");
			return teclado.nextBoolean();
		case 6:
			System.out
					.println("Ingrese el tipo de operación disponible para esta propiedad (VENTA, ALQUILER, PERMUTA):");
			return TipoDeOperacion.valueOf(teclado.next());
		case 7:
			System.out.println("Ingrese la nueva cantidad de metros cuadrados del terreno:");
			return teclado.nextDouble();
		case 8:
			System.out.println("Ingrese la nueva cantidad de hectáreas del campo:");
			return teclado.nextDouble();
		default:
			System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
			return null;

		}
	}
}
