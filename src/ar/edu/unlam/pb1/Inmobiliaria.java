package ar.edu.unlam.pb1;

import java.nio.channels.NonReadableChannelException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class Inmobiliaria {

	private String nombre;
	private String direccion;
	private String eMail;
	private Integer telefono;
//	private Casa casas[];
//	private ArrayList<Casa> casas;
	private LinkedList<Casa> casas;
//	private Departamento departamentos[];
	private LinkedList<Departamento> departamentos;
//	private PH phs[];
	private LinkedList<PH> phs;
//	private Terreno terrenos[];
	private LinkedList<Terreno> terrenos;
//	private Campo campos[];
	private LinkedList<Campo> campos;
//	private Cliente clientes[];
	private HashSet<Cliente> clientes;
//	private final Integer CANTIDAD_MAXIMA_DE_PROPIEDADES_POR_TIPO = 10;
//	private Integer cantidadDeCasasAgregadas = 0;
//	private Integer cantidadDeClientesAgregados = 0;
//	private final Integer CANTIDAD_MAXIMA_DE_CLIENTES = 500;

	public Inmobiliaria(String nombre, String direccion, String eMail, Integer telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.eMail = eMail;
		this.telefono = telefono;
		this.casas = new LinkedList<Casa>();
		this.departamentos = new LinkedList<Departamento>();
		this.phs = new LinkedList<PH>();
		this.terrenos = new LinkedList<Terreno>();
		this.clientes = new HashSet<Cliente>();
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

	public LinkedList<Casa> getCasas() {
		return casas;
	}
	
	public void setCasas(LinkedList<Casa> casas) {
		this.casas = casas;
	}

	public LinkedList<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(LinkedList<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	public LinkedList<PH> getPhs() {
		return phs;
	}

	public void setPhs(LinkedList<PH> phs) {
		this.phs = phs;
	}

	public LinkedList<Terreno> getTerrenos() {
		return terrenos;
	}

	public void setTerrenos(LinkedList<Terreno> terrenos) {
		this.terrenos = terrenos;
	}

	public LinkedList<Campo> getCampos() {
		return campos;
	}

	public void setCampos(LinkedList<Campo> campos) {
		this.campos = campos;
	}

	public HashSet<Cliente> getClientes() {
		return clientes;
	}
	
	public void setClientes(HashSet<Cliente> clientes) {
		this.clientes = clientes;
	}

	// Metodos para agregar propiedades
	public Boolean aniadirCasa(Casa casaNueva) {
		return casas.add(casaNueva);
	}

	public Boolean aniadirDepartamento(Departamento departamentoNuevo) {
		return departamentos.add(departamentoNuevo);
	}

	public Boolean aniadirPH(PH phNuevo) {
		return phs.add(phNuevo);
	}

	public Boolean aniadirTerreno(Terreno terrenoNuevo) {
		return terrenos.add(terrenoNuevo);
	}

	public Boolean aniadirCampo(Campo campoNuevo) {
		return campos.add(campoNuevo);
	}
	

	// Método para añadir un cliente
	public Boolean añadirCliente(Cliente clienteNuevo) {
		if (clienteNuevo == null || clienteNuevo.getDni() == null) {
			return false;
		}
		return clientes.add(clienteNuevo);
	}


	// Métodos para buscar propiedades
	public Casa buscarCasaPorCodigo(String codigo) {
		for (Casa casa : casas) {
			if (casa.getCodigo().equals(codigo)) {
				return casa;
			}
		}
		return null;
	}
	
	public Departamento buscarDepartamentoPorCodigo(String codigo) {
		for (Departamento departamento : departamentos) {
			if (departamento.getCodigo().equals(codigo)) {
				return departamento;
			}
		}
		return null;
	}

	public PH buscarPhPorCodigo(String codigo) {
		for (PH ph : phs) {
			if (ph.getCodigo().equals(codigo)) {
				return ph;
			}
		}
		return null;
	}

	public Terreno buscarTerrenoPorCodigo(String codigo) {
		for (Terreno terreno : terrenos) {
			if (terreno.getCodigo().equals(codigo)) {
				return terreno;
			}
		}
		return null;
	}

	public Campo buscarCampoPorCodigo(String codigo) {
		for (Campo campo : campos) {
			if (campo.getCodigo().equals(codigo)) {
				return campo;
			}
		}
		return null;
	}

	public Cliente buscarClienePorDni(Integer dni) {
		for (Cliente cliente : this.clientes) {
			if (cliente.getDni().equals(dni)) {
				return cliente;
			}
		}
		return null;
	}
	
	// Métodos para modificar propiedades
	public void modificarDatosCasa(Casa casa, Integer datoAModificar, Object dato) {
		if (casa != null) {
			switch (datoAModificar) {
			case 1:
				String calleNueva = (String) dato;
				casa.setCalle(calleNueva);
				break;
			case 2:
				Integer numeroNuevo = (Integer) dato;
				casa.setNumero(numeroNuevo);
				break;
			case 3:
				String localidadNueva = (String) dato;
				casa.setLocalidad(localidadNueva);
				break;
			case 4:
				Double precioNuevo = (Double) dato;
				casa.setPrecio(precioNuevo);
				break;
			case 5:
				Boolean disponibilidadNueva = (Boolean) dato;
				casa.setEstaDisponible(disponibilidadNueva);
				break;
			case 6:
				String operacionNueva = (String) dato;
				casa.setTipoDeOperacion(TipoDeOperacion.valueOf(operacionNueva));
				break;
			default:
				System.out.println("Opción no válida. Por favor, selecciona una opción del 1 al 6.");
				break;
			}
			System.out.println("Los datos de la casa han sido modificados con éxito.");

		}
	}

	public void modificarDatosDepartamento(Departamento departamento, Integer datoAModificar, Object dato) {
	    if (departamento != null) {
	        switch (datoAModificar) {
	            case 1:
	                String calleNueva = (String) dato;
	                departamento.setCalle(calleNueva);
	                break;
	            case 2:
	                Integer numeroNuevo = (Integer) dato;
	                departamento.setNumero(numeroNuevo);
	                break;
	            case 3:
	                String localidadNueva = (String) dato;
	                departamento.setLocalidad(localidadNueva);
	                break;
	            case 4:
	                Double precioNuevo = (Double) dato;
	                departamento.setPrecio(precioNuevo);
	                break;
	            case 5:
	                Boolean disponibilidadNueva = (Boolean) dato;
	                departamento.setEstaDisponible(disponibilidadNueva);
	                break;
	            case 6:
	                String operacionNueva = (String) dato;
	                departamento.setTipoDeOperacion(TipoDeOperacion.valueOf(operacionNueva));
	                break;
	            case 7:
	                Integer pisoNuevo = (Integer) dato;
	                departamento.setPiso(pisoNuevo);
	                break;
	            case 8:
	                Character departamentoNuevo = (Character) dato;
	                departamento.setDepartamento(departamentoNuevo);
	                break;
	            default:
	                System.out.println("Opción no válida. Por favor, selecciona una opción del 1 al 8.");
	                break;
	        }
	        System.out.println("Los datos del departamento han sido modificados con éxito.");
	    }
	}

	public void modificarDatosPh(PH ph, Integer datoAModificar, Object dato) {
	    if (ph != null) {
	        switch (datoAModificar) {
	            case 1:
	                String calleNueva = (String) dato;
	                ph.setCalle(calleNueva);
	                break;
	            case 2:
	                Integer numeroNuevo = (Integer) dato;
	                ph.setNumero(numeroNuevo);
	                break;
	            case 3:
	                String localidadNueva = (String) dato;
	                ph.setLocalidad(localidadNueva);
	                break;
	            case 4:
	                Double precioNuevo = (Double) dato;
	                ph.setPrecio(precioNuevo);
	                break;
	            case 5:
	                Boolean disponibilidadNueva = (Boolean) dato;
	                ph.setEstaDisponible(disponibilidadNueva);
	                break;
	            case 6:
	                String operacionNueva = (String) dato;
	                ph.setTipoDeOperacion(TipoDeOperacion.valueOf(operacionNueva));
	                break;
	            case 7:
	                Integer numeroDePHNuevo = (Integer) dato;
	                ph.setNumeroDePH(numeroDePHNuevo);
	                break;
	            default:
	                System.out.println("Opción no válida. Por favor, selecciona una opción del 1 al 7.");
	                break;
	        }
	        System.out.println("Los datos del PH han sido modificados con éxito.");
	    }
	}

	public void modificarDatosTerreno(Terreno terreno, Integer datoAModificar, Object dato) {
	    if (terreno != null) {
	        switch (datoAModificar) {
	            case 1:
	                String calleNueva = (String) dato;
	                terreno.setCalle(calleNueva);
	                break;
	            case 2:
	                Integer numeroNuevo = (Integer) dato;
	                terreno.setNumero(numeroNuevo);
	                break;
	            case 3:
	                String localidadNueva = (String) dato;
	                terreno.setLocalidad(localidadNueva);
	                break;
	            case 4:
	                Double precioNuevo = (Double) dato;
	                terreno.setPrecio(precioNuevo);
	                break;
	            case 5:
	                Boolean disponibilidadNueva = (Boolean) dato;
	                terreno.setEstaDisponible(disponibilidadNueva);
	                break;
	            case 6:
	                String operacionNueva = (String) dato;
	                terreno.setTipoDeOperacion(TipoDeOperacion.valueOf(operacionNueva));
	                break;
	            case 7:
	                Double metrosCuadradosNuevo = (Double) dato;
	                terreno.setMetrosCuadrados(metrosCuadradosNuevo);
	                break;
	            default:
	                System.out.println("Opción no válida. Por favor, selecciona una opción del 1 al 7.");
	                break;
	        }
	        System.out.println("Los datos del terreno han sido modificados con éxito.");
	    }
	}

	public void modificarDatosCampo(Campo campo, Integer datoAModificar, Object dato) {
	    if (campo != null) {
	        switch (datoAModificar) {
	            case 1:
	                String calleNueva = (String) dato;
	                campo.setCalle(calleNueva);
	                break;
	            case 2:
	                Integer numeroNuevo = (Integer) dato;
	                campo.setNumero(numeroNuevo);
	                break;
	            case 3:
	                String localidadNueva = (String) dato;
	                campo.setLocalidad(localidadNueva);
	                break;
	            case 4:
	                Double precioNuevo = (Double) dato;
	                campo.setPrecio(precioNuevo);
	                break;
	            case 5:
	                Boolean disponibilidadNueva = (Boolean) dato;
	                campo.setEstaDisponible(disponibilidadNueva);
	                break;
	            case 6:
	                String operacionNueva = (String) dato;
	                campo.setTipoDeOperacion(TipoDeOperacion.valueOf(operacionNueva));
	                break;
	            case 7:
	                Double hectareasNueva = (Double) dato;
	                campo.setHectareas(hectareasNueva);
	                break;
	            default:
	                System.out.println("Opción no válida. Por favor, selecciona una opción del 1 al 7.");
	                break;
	        }
	        System.out.println("Los datos del campo han sido modificados con éxito.");
	    }
	}

	// métodos para odenar propiedades según su tipo
	public ArrayList<Casa> ordenarCasasPorPrecio() {
	    ArrayList<Casa> casasOrdenadas = new ArrayList<>(casas);
	    casasOrdenadas.sort(Comparator.comparingDouble(Casa::getPrecio));
	    return casasOrdenadas;
	}


	public ArrayList<Departamento> ordenarDepartamentosPorPrecio() {
	    ArrayList<Departamento> departamentosOrdenados = new ArrayList<>(departamentos);
	    departamentosOrdenados.sort(Comparator.comparingDouble(Departamento::getPrecio));
	    return departamentosOrdenados;
	}

	public ArrayList<PH> ordenarPhsPorPrecio() {
	    ArrayList<PH> phsOrdenados = new ArrayList<>(phs);
	    phsOrdenados.sort(Comparator.comparingDouble(PH::getPrecio));
	    return phsOrdenados;
	}

	public ArrayList<Terreno> ordenarTerrenosPorPrecio() {
	    ArrayList<Terreno> terrenosOrdenados = new ArrayList<>(terrenos);
	    terrenosOrdenados.sort(Comparator.comparingDouble(Terreno::getPrecio));
	    return terrenosOrdenados;
	}

	public ArrayList<Campo> ordenarCamposPorPrecio() {
	    ArrayList<Campo> camposOrdenados = new ArrayList<>(campos);
	    camposOrdenados.sort(Comparator.comparingDouble(Campo::getPrecio));
	    return camposOrdenados;
	}

	public ArrayList<Casa> ordenarCasasPorLocalidad() {
	    ArrayList<Casa> casasOrdenadas = new ArrayList<>(casas);
	    casasOrdenadas.sort(Comparator.comparing(Casa::getLocalidad));
	    return casasOrdenadas;
	}

	public ArrayList<Departamento> ordenarDepartamentosPorLocalidad() {
	    ArrayList<Departamento> departamentosOrdenados = new ArrayList<>(departamentos);
	    departamentosOrdenados.sort(Comparator.comparing(Departamento::getLocalidad));
	    return departamentosOrdenados;
	}
	
	public ArrayList<PH> ordenarPhsPorLocalidad() {
	    ArrayList<PH> phsOrdenados = new ArrayList<>(phs);
	    phsOrdenados.sort(Comparator.comparing(PH::getLocalidad));
	    return phsOrdenados;
	}
	
	public ArrayList<Terreno> ordenarTerrenosPorLocalidad() {
	    ArrayList<Terreno> terrenosOrdenados = new ArrayList<>(terrenos);
	    terrenosOrdenados.sort(Comparator.comparing(Terreno::getLocalidad));
	    return terrenosOrdenados;
	}
	
	public ArrayList<Campo> ordenarCamposPorLocalidad() {
	    ArrayList<Campo> camposOrdenados = new ArrayList<>(campos);
	    camposOrdenados.sort(Comparator.comparing(Campo::getLocalidad));
	    return camposOrdenados;
	}

	// buscar propiedades por precio especifico
	public LinkedList<Casa> buscarCasasPorRangoDePrecio(double precioMinimo, double precioMaximo) {
	    LinkedList<Casa> casasEnRango = new LinkedList<Casa>();
	    
	    for (Casa actualCasa : casas) {
	        if (actualCasa.getPrecio() >= precioMinimo && actualCasa.getPrecio() <= precioMaximo) {
	            casasEnRango.add(actualCasa);
	        }
	    }

	    Collections.sort(casasEnRango, Comparator.comparingDouble(Casa::getPrecio));

	    return casasEnRango;
	}

	public LinkedList<Departamento> buscarDepartamentosPorRangoDePrecio(double precioMinimo, double precioMaximo) {
		LinkedList<Departamento> departamentosEnRango = new LinkedList<Departamento>();
		
		for (Departamento actualDepartamento : departamentos) {
			if (actualDepartamento.getPrecio() >= precioMinimo && actualDepartamento.getPrecio() <= precioMaximo) {
				departamentosEnRango.add(actualDepartamento);				
			}
		}
		
	    Collections.sort(departamentosEnRango, Comparator.comparingDouble(Departamento::getPrecio));

		return departamentosEnRango;
	}

	public LinkedList<PH> buscarPhsPorRangoDePrecio(double precioMinimo, double precioMaximo) {
		LinkedList<PH> phsEnRango = new LinkedList<PH>();
		
		for (PH actualPh : phs) {
			if (actualPh.getPrecio() >= precioMinimo && actualPh.getPrecio() <= precioMaximo) {
				phsEnRango.add(actualPh);			
			}
		}
		
	    Collections.sort(phsEnRango, Comparator.comparingDouble(PH::getPrecio));

		return phsEnRango;
	}

	public LinkedList<Terreno> buscarTerrenosPorRangoDePrecio(double precioMinimo, double precioMaximo) {
		LinkedList<Terreno> terrenosEnRango = new LinkedList<Terreno>();
		
		for (Terreno actualTerreno : terrenos) {
			if (actualTerreno.getPrecio() >= precioMinimo && actualTerreno.getPrecio() <= precioMaximo) {
				terrenosEnRango.add(actualTerreno);			
			}
		}
		
	    Collections.sort(terrenosEnRango, Comparator.comparingDouble(Terreno::getPrecio));
	    
		return terrenosEnRango;
	}

	public LinkedList<Campo> buscarCamposPorRangoDePrecio(double precioMinimo, double precioMaximo) {
		LinkedList<Campo> camposEnRango = new LinkedList<Campo>();
		
		for (Campo actualCampo : campos) {
			if (actualCampo.getPrecio() >= precioMinimo && actualCampo.getPrecio() <= precioMaximo) {
				camposEnRango.add(actualCampo);			
			}
		}
		
	    Collections.sort(camposEnRango, Comparator.comparingDouble(Campo::getPrecio));

		return camposEnRango;	
	}

	public ArrayList<Casa> buscarCasasPorLocalidad(String localidadDeseada) {
		ArrayList<Casa> casasConLocalidadBuscada = new ArrayList<Casa>();

		for (Casa actualCasa : casas) {
			if (actualCasa.getLocalidad().equals(localidadDeseada)) {
				casasConLocalidadBuscada.add(actualCasa);
			}
		}

		return casasConLocalidadBuscada;
	}

	public ArrayList<Departamento> buscarDepartamentosPorLocalidad(String localidadDeseada) {
		ArrayList<Departamento> departamentosConLocalidadBuscada = new ArrayList<Departamento>();

		for (Departamento actualDepartamento : departamentos) {
			if (actualDepartamento.getLocalidad().equals(localidadDeseada)) {
				departamentosConLocalidadBuscada.add(actualDepartamento);
			}
		}

		return departamentosConLocalidadBuscada;
	}
	
	public ArrayList<PH> buscarPhsPorLocalidad(String localidadDeseada) {
		ArrayList<PH> phsConLocalidadBuscada = new ArrayList<PH>();

		for (PH actualPh : phs) {
			if (actualPh.getLocalidad().equals(localidadDeseada)) {
				phsConLocalidadBuscada.add(actualPh);
			}
		}

		return phsConLocalidadBuscada;
	}

	public ArrayList<Terreno> buscarTerrenosPorLocalidad(String localidadDeseada) {
		ArrayList<Terreno> terrenosConLocalidadBuscada = new ArrayList<Terreno>();

		for (Terreno actualTerreno : terrenos) {
			if (actualTerreno.getLocalidad().equals(localidadDeseada)) {
				terrenosConLocalidadBuscada.add(actualTerreno);
			}
		}

		return terrenosConLocalidadBuscada;
	}

	public ArrayList<Campo> buscarCamposPorLocalidad(String localidadDeseada) {
		ArrayList<Campo> camposConLocalidadBuscada = new ArrayList<Campo>();

		for (Campo actualCampo : campos) {
			if (actualCampo.getLocalidad().equals(localidadDeseada)) {
				camposConLocalidadBuscada.add(actualCampo);
			}
		}

		return camposConLocalidadBuscada;
	}

	public Double calcularPrecioPromedioDeCasas() {
		Double promedio = 0.0;
		Double sumatoria = 0.0;
		Integer cantidadDeCasas = 0;

		for (Casa casaActual : casas) {
			if (casaActual != null) {
				sumatoria += casaActual.getPrecio();
				cantidadDeCasas++;
			}
		}

		if (cantidadDeCasas == 0) {
			return 0.0;
		}

		promedio = sumatoria / cantidadDeCasas;
		return promedio;
	}

	public Double calcularPrecioPromedioDeDepartamentos() {
		Double promedio = 0.0;
		Double sumatoria = 0.0;
		Integer cantidadDeDepartamentos = 0;

		for (Departamento departamentoActual : departamentos) {
			if (departamentoActual != null) {
				sumatoria += departamentoActual.getPrecio();
				cantidadDeDepartamentos++;
			}
		}

		if (cantidadDeDepartamentos == 0) {
			return 0.0;
		}

		promedio = sumatoria / cantidadDeDepartamentos;
		return promedio;
	}

	public String mostrarCasas() {
		String resultado = "";
		for (Casa actual : casas) {
			resultado += actual + "\n";

		}
		return resultado;

	}

	public String mostrarDepartamentos() {
		String resultado = "";
		for (Departamento actual : departamentos) {
			resultado += actual + "\n";

		}
		return resultado;
	}

	public String mostrarPhs() {
		String resultado = "";
		for (PH actual : phs) {
			resultado += actual + "\n";

		}
		return resultado;
	}

	public String mostrarTerrenos() {
		String resultado = "";
		for (Terreno actual : terrenos) {
			resultado += actual + "\n";

		}
		return resultado;
	}

	public String mostrarCampos() {
		String resultado = "";
		for (Campo actual : campos) {
			resultado += actual + "\n";

		}
		return resultado;
	}



}
