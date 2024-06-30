package ar.edu.unlam.pb1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.TreeSet;

public class Inmobiliaria {

	private String nombre;
	private String direccion;
	private String eMail;
	private Integer telefono;
	private HashSet<Propiedad> propiedades;
	private HashSet<Cliente> clientes;
	private ArrayList<Operacion> historialOperaciones;

	public Inmobiliaria(String nombre, String direccion, String eMail, Integer telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.eMail = eMail;
		this.telefono = telefono;
		this.propiedades = new HashSet<Propiedad>();
		this.clientes = new HashSet<Cliente>();
        this.historialOperaciones = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	
	public HashSet<Propiedad> getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(HashSet<Propiedad> propiedades) {
		this.propiedades = propiedades;
	}

	public HashSet<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(HashSet<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public ArrayList<String> getHistorialOperaciones() {
	    ArrayList<String> operacionesString = new ArrayList<>();
	    for (Operacion operacion : historialOperaciones) {
	        operacionesString.add(operacion.toString());
	    }
	    return operacionesString;
	}

	public boolean clienteEstaRegistrado(Cliente cliente) {
        return clientes.contains(cliente);
    }

    public boolean propiedadEstaRegistrada(Propiedad propiedad) {
        return propiedades.contains(propiedad);
    }

    public void aniadirPropiedad(Propiedad propiedad) throws UmbralMinimoNoAlcanzadoException {
        if (propiedad == null) {
            throw new IllegalArgumentException("La propiedad no puede ser nula");
        }
        if (propiedad.getPrecio() < 10000.0) {
            throw new UmbralMinimoNoAlcanzadoException("El precio de la propiedad está por debajo del umbral mínimo de 10000");
        }
        propiedades.add(propiedad);
    }

	public Boolean aniadirCliente(Cliente clienteNuevo) {
		if (clienteNuevo == null || clienteNuevo.getDni() == null) {
			return false;
		}
		return clientes.add(clienteNuevo);
	}

	// buscar
	public Propiedad buscarPropiedadPorCodigo(String codigo) {
		if (codigo == null || codigo.isEmpty()) {
			throw new IllegalArgumentException("El código no puede ser nulo o vacío");
		}

		for (Propiedad propiedad : propiedades) {
			if (propiedad.getCodigo().equals(codigo)) {
				return propiedad;
			}
		}
		throw new NoSuchElementException("No se encontró una propiedad con el código: " + codigo);
	}

	public Cliente buscarClienePorDni(Integer dni) {
		if (dni == null || dni == 0) {
			throw new IllegalArgumentException("El DNI no puede ser nulo o 0 (cero)");
		}

		for (Cliente cliente : clientes) {
			if (cliente.getDni().equals(dni)) {
				return cliente;
			}
		}
		throw new NoSuchElementException("No se encontró un cliente con el DNI: " + dni);
	}

	// mostrar propiedades
	public String mostrarPropiedadesPorTipo(TiposDePropiedades tipoSolicitado) {
		String resultado = "";

		for (Propiedad propiedad : propiedades) {
			if (tipoSolicitado == null || propiedad.getTipoDePropiedad() == tipoSolicitado) {
				resultado += propiedad.toString() + "\n";
			}
		}

		if (resultado.isEmpty()) {
			throw new NoSuchElementException("No hay propiedades del tipo especificado.");
		}

		return resultado;
	}

	public String mostrarPropiedades() {
		String resultado = "";

		for (TiposDePropiedades tipo : TiposDePropiedades.values()) {
			resultado += tipo.name() + ":\n";
			resultado += mostrarPropiedadesPorTipo(tipo);
			resultado += "\n";
		}

		return resultado;
	}

	// modificar
	public void modificarDatosPropiedad(String codigo, DatosAModificar datoAModificar, Object dato) {
		Propiedad propiedad = buscarPropiedadPorCodigo(codigo);
		switch (datoAModificar) {
		case CALLE:
			if (!(dato instanceof String)) {
				throw new IllegalArgumentException("La calle debe ser una cadena de texto.");
			}
			propiedad.setCalle((String) dato);
			break;
		case NUMERO:
			if (!(dato instanceof Integer)) {
				throw new IllegalArgumentException("El número debe ser un entero.");
			}
			propiedad.setNumero((Integer) dato);
			break;
		case LOCALIDAD:
			if (!(dato instanceof String)) {
				throw new IllegalArgumentException("La localidad debe ser una cadena de texto.");
			}
			propiedad.setLocalidad((String) dato);
			break;
		case PRECIO:
		    if (!(dato instanceof Double)) {
		        throw new IllegalArgumentException("El precio debe ser un decimal (1000.0).");
		    }
		    propiedad.setPrecio((Double) dato);
		    break;
		case DISPONIBILIDAD:
			if (!(dato instanceof Boolean)) {
				throw new IllegalArgumentException(
						"El estado de disponibilidad debe ser un valor booleano (true/false).");
			}
			propiedad.setEstaDisponible((Boolean) dato);
			break;
		case TIPO_DE_OPERACION:
			if (!(dato instanceof TipoDeOperacion)) {
				throw new IllegalArgumentException(
						"El tipo de operación debe ser una instancia de TipoDeOperacion (VENTA, ALQUILER, PERMUTA).");
			}
			propiedad.setTipoDeOperacion(TipoDeOperacion.valueOf((String) dato));
			break;
		default:
			break;
		}
		if (propiedad instanceof Departamento) {
			Departamento departamento = (Departamento) propiedad;
			switch (datoAModificar) {
			case PISO:
				if (!(dato instanceof Integer)) {
					throw new IllegalArgumentException("El piso debe ser un entero.");
				}
				departamento.setPiso((Integer) dato);
				break;
			case DEPARTAMENTO:
				if (!(dato instanceof Character)) {
					throw new IllegalArgumentException("El departamento debe ser una letra.");
				}
				departamento.setDepartamento((Character) dato);
				break;
			default:
				break;
			}
		} else if (propiedad instanceof PH) {
			PH ph = (PH) propiedad;
			switch (datoAModificar) {
			case NUMERO_PH:
				if (!(dato instanceof Integer)) {
					throw new IllegalArgumentException("El número del PH debe ser un entero.");
				}
				ph.setNumeroDePH((Integer) dato);
				break;
			default:
				break;
			}
		} else if (propiedad instanceof Terreno) {
			Terreno terreno = (Terreno) propiedad;
			switch (datoAModificar) {
			case METROS_CUADRADOS_TERRENO:
			    if (!(dato instanceof Double)) {
			        throw new IllegalArgumentException("La cantidad de metros cuadrados debe ser un decimal (1000.0).");
			    }
			    terreno.setMetrosCuadrados((Double) dato);
			    break;
			default:
				break;
			}
		} else if (propiedad instanceof Campo) {
			Campo campo = (Campo) propiedad;
			switch (datoAModificar) {
			case HECTAREAS_CAMPO:
				if (!(dato instanceof Double)) {
					throw new IllegalArgumentException("La cantidad de hectareas debe ser un decimal (1000.0).");
				}
				campo.setHectareas((Double) dato);
				break;
			default:
				break;
			}
		}
	}

	// ordenar por precio
	public TreeSet<Propiedad> ordenarPropiedadesPorPrecio() {
		TreeSet<Propiedad> propiedadesOrdenadas = new TreeSet<>();
		propiedadesOrdenadas.addAll(propiedades);
		return propiedadesOrdenadas;
	}

	// ordenar por localidad
	public TreeSet<Propiedad> ordenarPropiedadesPorLocalidad() {
		TreeSet<Propiedad> propiedadesOrdenadas = new TreeSet<>(new OrdenarPropiedadesPorLocalidad());
		propiedadesOrdenadas.addAll(propiedades);
		return propiedadesOrdenadas;
	}

	// buscar por rango de precio
	public TreeSet<Propiedad> buscarPropiedadesPorRangoDePrecio(double precioMinimo, double precioMaximo) throws SinResultadosException {
		TreeSet<Propiedad> propiedadesEnRango = new TreeSet<>();

		for (Propiedad propiedad : propiedades) {
			if (propiedad.getPrecio() >= precioMinimo && propiedad.getPrecio() <= precioMaximo) {
				propiedadesEnRango.add(propiedad);
			}
		}
		
		if (propiedadesEnRango.isEmpty()) {
	        throw new SinResultadosException("No se encontraron propiedades en el rango desde " + precioMinimo + " hasta " + precioMaximo);
	    }
		

		return propiedadesEnRango;
	}

	// buscar por localidad
	public TreeSet<Propiedad> buscarPropiedadesPorLocalidad(String localidad) throws SinResultadosException {
		TreeSet<Propiedad> propiedadesEnRango = new TreeSet<>(new OrdenarPropiedadesPorLocalidad());

		for (Propiedad propiedad : propiedades) {
			if (propiedad.getLocalidad().equals(localidad)) {
				propiedadesEnRango.add(propiedad);
			}
		}

		if (propiedadesEnRango.isEmpty()) {
	        throw new SinResultadosException("No se encontraron propiedades en la localidad: " + localidad);
	    }
		
		return propiedadesEnRango;
	}

	// operaciones
	public void venderPropiedad(Propiedad propiedad, Cliente comprador) throws PropiedadNoDisponibleException, ClienteNoRegistradoException, PropiedadNoRegistradaException {
	    if (!clienteEstaRegistrado(comprador)) {
	        throw new ClienteNoRegistradoException("El comprador no está registrado en la inmobiliaria.");
	    }
	    if (!propiedadEstaRegistrada(propiedad)) {
	        throw new PropiedadNoRegistradaException("La propiedad no está registrada en la inmobiliaria.");
	    }
	    Venta venta = new Venta(propiedad, propiedad.getPropietario(), comprador, LocalDate.now());
	    venta.realizarOperacion(propiedad, comprador, LocalDate.now());
	    
	    historialOperaciones.add(venta);
	}



	public void alquilarPropiedad(Propiedad propiedad, Cliente inquilino) throws PropiedadNoDisponibleException, ClienteNoRegistradoException, PropiedadNoRegistradaException {
		if (!clienteEstaRegistrado(inquilino)) {
	        throw new ClienteNoRegistradoException("El inquilino no está registrado en la inmobiliaria.");
	    }
	    if (!propiedadEstaRegistrada(propiedad)) {
	        throw new PropiedadNoRegistradaException("La propiedad no está registrada en la inmobiliaria.");
	    }
		Alquiler alquiler = new Alquiler(propiedad, propiedad.getPropietario(), inquilino, LocalDate.now());
		alquiler.realizarOperacion(propiedad, inquilino, LocalDate.now());
		
	    historialOperaciones.add(alquiler);
	}

	public void permutarPropiedades(Propiedad propiedad1, Propiedad propiedad2, Cliente cliente1, Cliente cliente2)
			throws PropiedadNoDisponibleException, ClienteNoRegistradoException, PropiedadNoRegistradaException {
		if (!clienteEstaRegistrado(cliente1) || !clienteEstaRegistrado(cliente2)) {
	        throw new ClienteNoRegistradoException("El cliente no está registrado en la inmobiliaria.");
	    }
	    if (!propiedadEstaRegistrada(propiedad1) || !propiedadEstaRegistrada(propiedad2)) {
	        throw new PropiedadNoRegistradaException("La propiedad no está registrada en la inmobiliaria.");
	    }
		Permuta permuta = new Permuta(propiedad1, propiedad2, cliente1, cliente2, LocalDate.now());
		permuta.realizarOperacion(propiedad1, propiedad2, cliente1, cliente2, LocalDate.now());
		
	    historialOperaciones.add(permuta);
	}
	
	public ArrayList<String> buscarOperacionesPorCodigoPropiedad(String codigoPropiedad) {
        ArrayList<String> resultados = new ArrayList<>();

        for (Operacion operacion : historialOperaciones) {
            if (operacion instanceof Venta) {
                Venta venta = (Venta) operacion;
                if (venta.getPropiedad().getCodigo().equals(codigoPropiedad)) {
                    resultados.add(venta.toString());
                }
            } else if (operacion instanceof Alquiler) {
                Alquiler alquiler = (Alquiler) operacion;
                if (alquiler.getPropiedad().getCodigo().equals(codigoPropiedad)) {
                    resultados.add(alquiler.toString());
                }
            } else if (operacion instanceof Permuta) {
                Permuta permuta = (Permuta) operacion;
                if (permuta.getPropiedad().getCodigo().equals(codigoPropiedad) || permuta.getPropiedad2().getCodigo().equals(codigoPropiedad)) {
                    resultados.add(permuta.toString());
                }
            }
        }

        return resultados;
    }
	
	// calcular precio promedio de cada tipo de propiedad
	public Double calcularPromedioPrecio(TiposDePropiedades tipo) {
		Double sumatoria = 0.0;
		int contador = 0;
		for (Propiedad propiedad : propiedades) {
			if (propiedad.getTipoDePropiedad() == tipo) {
				sumatoria += propiedad.getPrecio();
				contador++;
			}
		}
		return (contador > 0) ? sumatoria / contador : 0.0;
	}
	
	// calcular precio promedio general
	public Double calcularPromedioPrecio() {
		Double sumatoria = 0.0;
		int contador = 0;
		for (Propiedad propiedad : propiedades) {
			sumatoria += propiedad.getPrecio();
			contador++;
		}
		return (contador > 0) ? sumatoria / contador : 0.0;
	}
}
