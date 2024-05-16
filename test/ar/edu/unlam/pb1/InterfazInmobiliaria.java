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
			if (opcionMenu < 1 || opcionMenu > OpcionMenu.values().length) {
				System.out.println(
						"Opción no válida. Por favor, elige una opción entre 1 y " + OpcionMenu.values().length);
				continue;
			}
			switch (OpcionMenu.values()[opcionMenu - 1]) {
			case AGREGAR_PROPIEDAD:
				tipoPropiedad = menuPropiedades(teclado);
				agregarPropiedad(tipoPropiedad);
				break;
			case MOSTRAR_PROPIEDADES:
				System.out.println("\nCasas: \n" + inmobiliariaActual.mostrarPropiedades(TiposDePropiedades.CASA));
				System.out.println(
						"\nDepartamentos: \n" + inmobiliariaActual.mostrarPropiedades(TiposDePropiedades.DEPARTAMENTO));
				System.out.println("\nPhs: \n" + inmobiliariaActual.mostrarPropiedades(TiposDePropiedades.PH));
				System.out
						.println("\nTerrenos: \n" + inmobiliariaActual.mostrarPropiedades(TiposDePropiedades.TERRENO));
				System.out.println("\nCampos: \n" + inmobiliariaActual.mostrarPropiedades(TiposDePropiedades.CAMPO));
			case MODIFICAR_PROPIEDAD:
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
			case BUSCAR_PROPIEDAD_POR_VENTA_Y_ALQUILER:
				tipoPropiedad = menuPropiedades(teclado);
				System.out.println("\nIntroduce la operación (VENTA/ALQUILER):");
				TipoDeOperacion operacionDeseada = obtenerOperacion(teclado.next().toUpperCase());
				buscarPropiedadesPorOperacion(tipoPropiedad, operacionDeseada);
				break;
			case REALIZAR_VENTA:
				System.out.println("\nIntroduce el DNI del comprador:");
				Integer dniComprador = teclado.nextInt();
				System.out.println("\nIntroduce el código de la propiedad que deseas comprar:");
				String codigoPropiedadAComprar = teclado.next();
				comprarPropiedad(dniComprador, codigoPropiedadAComprar);
				break;
			case REALIZAR_ALQUILER:
				System.out.println("\nIntroduce el DNI del inquilino:");
				Integer dniInquilino = teclado.nextInt();
				System.out.println("\nIntroduce el código de la propiedad que deseas alquilar:");
				String codigoPropiedadAAlquilar = teclado.next();
				alquilarPropiedad(dniInquilino, codigoPropiedadAAlquilar);
				break;
			case CALCULAR_EL_PRECIO_PROMEDIO:
				tipoPropiedad = menuPropiedades(teclado);
				System.out.println(inmobiliariaActual.calcularPromedioPrecio(tipoPropiedad));
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

	private static void agregarPropiedad(Integer opcionAgregarPropiedad) {
		Scanner teclado = new Scanner(System.in);
		Propiedad propiedadNueva = null;

		switch (TiposDePropiedades.values()[opcionAgregarPropiedad - 1]) {
		case CASA:
			propiedadNueva = pedirDatosAgregarCasa();
			break;
		case DEPARTAMENTO:
			propiedadNueva = pedirDatosAgregarDepartamento();
			break;
		case PH:
			propiedadNueva = pedirDatosAgregarPH();
			break;
		case TERRENO:
			propiedadNueva = pedirDatosAgregarTerreno();
			break;
		case CAMPO:
			propiedadNueva = pedirDatosAgregarCampo();
			break;
		}

		if (propiedadNueva != null) {
			inmobiliariaActual.aniadirPropiedad(propiedadNueva);
			System.out.println("\nPropiedad añadida con éxito");
		} else {
			System.out.println("\nNo se pudo añadir la propiedad. Por favor, intente nuevamente.");
		}

		System.out.println("\n¿Deseas agregar otra propiedad? (true/false): ");
		Boolean agregarOtraPropiedad = teclado.nextBoolean();
		teclado.nextLine();

		if (agregarOtraPropiedad) {
			Integer tipoPropiedadAAgregar = menuPropiedades(teclado);
			agregarPropiedad(tipoPropiedadAAgregar);
		}
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

	private static Integer menuModificarPropiedad(Scanner teclado, Integer tipoPropiedad) {
		Integer opcionSeleccionada;
		System.out.println("Selecciona el dato que quieres modificar:");
		System.out.println("1. Calle");
		System.out.println("2. Número");
		System.out.println("3. Localidad");
		System.out.println("4. Precio");
		System.out.println("5. Disponibilidad");
		System.out.println("6. Tipo de operación");

		if (tipoPropiedad == 2) {
			System.out.println("7. Piso");
			System.out.println("8. Departamento");
		} else if (tipoPropiedad == 3) {
			System.out.println("9. Número de PH");
		} else if (tipoPropiedad == 4) {
			System.out.println("10. Metros cuadrados");
		} else if (tipoPropiedad == 5) {
			System.out.println("11. Hectáreas");
		}

		opcionSeleccionada = teclado.nextInt();
		return opcionSeleccionada;
	}

	private static Object solicitarDato(Integer datoAModificar) {
		Scanner teclado = new Scanner(System.in);
		switch (datoAModificar) {
		case 1:
			System.out.println("Ingrese el nuevo nombre de la calle:");
			return teclado.nextLine().toUpperCase();
		case 2:
			System.out.println("Ingrese el nuevo número de la propiedad:");
			return teclado.nextInt();
		case 3:
			System.out.println("Ingrese el nuevo nombre de la localidad:");
			teclado.nextLine();
			return teclado.nextLine().toUpperCase();
		case 4:
			System.out.println("Ingrese el nuevo precio de la propiedad:");
			return teclado.nextDouble();
		case 5:
			System.out.println("Ingrese si la propiedad se encuentra disponible (true/false):");
			return teclado.nextBoolean();
		case 6:
			System.out
					.println("Ingrese el tipo de operación disponible para esta propiedad (VENTA, ALQUILER, PERMUTA):");
			teclado.nextLine();
			return TipoDeOperacion.valueOf(teclado.nextLine().toUpperCase());
		case 7:
			System.out.println("Ingrese el nuevo piso del departamento:");
			return teclado.nextInt();
		case 8:
			System.out.println("Ingrese el nuevo número de departamento:");
			teclado.nextLine();
			return teclado.nextLine().charAt(0);
		case 9:
			System.out.println("Ingrese el nuevo número de PH:");
			return teclado.nextInt();
		case 10:
			System.out.println("Ingrese la nueva cantidad de metros cuadrados del terreno:");
			return teclado.nextDouble();
		case 11:
			System.out.println("Ingrese la nueva cantidad de hectáreas del campo:");
			return teclado.nextDouble();
		default:
			System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
			return null;
		}
	}

	private static void buscarYModificarPropiedad(String codigo, Integer datoAModificar, Object dato) {
		Propiedad propiedad = inmobiliariaActual.buscarPropiedadPorCodigo(codigo);
		if (propiedad != null) {
			System.out.println("\nPropiedad encontrada: " + propiedad);
			inmobiliariaActual.modificarDatosPropiedad(propiedad, datoAModificar, dato);
		} else {
			System.out.println("No se encontró ninguna propiedad con el código proporcionado.");
		}
	}

	private static void agregarCliente() {
		Scanner teclado = new Scanner(System.in);
		Boolean exito;
		Cliente clienteNuevo = pedirDatosAgregarCliente();
		exito = inmobiliariaActual.aniadirCliente(clienteNuevo);
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

	private static Integer menuOrdenarPropiedades(Scanner teclado) {
		Integer opcionSeleccionada;
		System.out.print("\nSeleccione el tipo de propiedad que desea ordenar:");
		System.out.print("\n1. Casa");
		System.out.print("\n2. Departamento");
		System.out.print("\n3. PH");
		System.out.print("\n4. Terreno");
		System.out.print("\n5. Campo");
		opcionSeleccionada = teclado.nextInt();
		return opcionSeleccionada;
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
		}
		System.out.println("\n¿Deseas ordenar otro tipo de propiedad? (true/false): ");
		Boolean ordenarOtroTipoPropiedad = teclado.nextBoolean();
		teclado.nextLine();

		if (ordenarOtroTipoPropiedad) {
			Integer tipoPropiedadAOrdenar = menuPropiedades(teclado);
			ordenarPropiedadesPorPrecio(tipoPropiedadAOrdenar);
		}
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
	
	private static TipoDeOperacion obtenerOperacion(String operacionString) {
	    for (TipoDeOperacion operacion : TipoDeOperacion.values()) {
	        if (operacion.name().equals(operacionString)) {
	            return operacion;
	        }
	    }
	    return null;
	}


	private static void buscarPropiedadesPorOperacion(Integer tipoPropiedad, TipoDeOperacion operacionDeseada) {
		Scanner teclado = new Scanner(System.in);
		switch (tipoPropiedad) {
		case 1:
			System.out.println("\nCasas:");
			inmobiliariaActual.buscarCasasPorOperacion(operacionDeseada);
			break;
		case 2:
			System.out.println("\nDepartamentos:");
			inmobiliariaActual.buscarCasasPorOperacion(operacionDeseada);
			break;
		case 3:
			System.out.println("\nPHs:");
			inmobiliariaActual.buscarCasasPorOperacion(operacionDeseada);
			break;
		case 4:
			System.out.println("\nTerrenos:");
			inmobiliariaActual.buscarCasasPorOperacion(operacionDeseada);
			break;
		case 5:
			System.out.println("\nCampos:");
			inmobiliariaActual.buscarCasasPorOperacion(operacionDeseada);
			break;
		}
			System.out.println("\n¿Deseas ordenar otro tipo de propiedad? (true/false): ");
			Boolean ordenarOtroTipoPropiedad = teclado.nextBoolean();
			teclado.nextLine();

			if (ordenarOtroTipoPropiedad) {
				Integer tipoPropiedadABuscar = menuPropiedades(teclado);
				System.out.println("\nIntroduce la operación (VENTA/ALQUILER):");
				String operacionNueva = teclado.next().toUpperCase();
				buscarPropiedadesPorLocalidad(tipoPropiedadABuscar, operacionNueva);
			}
	}

	private static void comprarPropiedad(Integer dniComprador, String codigoPropiedad) {
		Cliente comprador = inmobiliariaActual.buscarClienePorDni(dniComprador);
		if (comprador != null) {
			Propiedad propiedadAComprar = inmobiliariaActual.buscarPropiedadPorCodigo(codigoPropiedad);
			if (propiedadAComprar != null && propiedadAComprar.estaDisponiblePara(TipoDeOperacion.VENTA)) {
				comprador.comprarPropiedad(propiedadAComprar);
				System.out.println("La propiedad ha sido comprada con éxito.");
			} else {
				System.out.println("La propiedad no está disponible para la venta o no existe.");
			}
		} else {
			System.out.println("El DNI introducido no corresponde a ningún cliente registrado.");
		}
	}
	
	private static void alquilarPropiedad(Integer dniInquilino, String codigoPropiedadAAlquilar) {
		Cliente inquilino = inmobiliariaActual.buscarClienePorDni(dniInquilino);
		if (inquilino != null) {
			Propiedad propiedadAAlquilar = inmobiliariaActual.buscarPropiedadPorCodigo(codigoPropiedadAAlquilar);
			if (propiedadAAlquilar != null && propiedadAAlquilar.estaDisponiblePara(TipoDeOperacion.ALQUILER)) {
				inquilino.alquilarPropiedad(propiedadAAlquilar);
				System.out.println("La propiedad ha sido comprada con éxito.");
			} else {
				System.out.println("La propiedad no está disponible para la venta o no existe.");
			}
		} else {
			System.out.println("El DNI introducido no corresponde a ningún cliente registrado.");
		}		
	}

}
