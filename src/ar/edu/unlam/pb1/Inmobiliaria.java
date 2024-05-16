package ar.edu.unlam.pb1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;

public class Inmobiliaria {

	private String nombre;
	private String direccion;
	private String eMail;
	private Integer telefono;
	private LinkedList<Casa> casas;
	private LinkedList<Departamento> departamentos;
	private LinkedList<PH> phs;
	private LinkedList<Terreno> terrenos;
	private LinkedList<Campo> campos;
	private HashSet<Cliente> clientes;

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

	// añadir
	public void aniadirPropiedad(Propiedad propiedad) {
		if (propiedad instanceof Casa) {
			casas.add((Casa) propiedad);
		} else if (propiedad instanceof Departamento) {
			departamentos.add((Departamento) propiedad);
		} else if (propiedad instanceof PH) {
			phs.add((PH) propiedad);
		} else if (propiedad instanceof Terreno) {
			terrenos.add((Terreno) propiedad);
		} else if (propiedad instanceof Campo) {
			campos.add((Campo) propiedad);
		} else {
			System.out.println("Tipo de propiedad no reconocido.");
		}
	}

	public Boolean aniadirCliente(Cliente clienteNuevo) {
		if (clienteNuevo == null || clienteNuevo.getDni() == null) {
			return false;
		}
		return clientes.add(clienteNuevo);
	}

	// buscar
	public Propiedad buscarPropiedadPorCodigo(String codigo) {
		for (Casa casa : casas) {
			if (casa.getCodigo().equals(codigo)) {
				return casa;
			}
		}
		for (Departamento departamento : departamentos) {
			if (departamento.getCodigo().equals(codigo)) {
				return departamento;
			}
		}
		for (PH ph : phs) {
			if (ph.getCodigo().equals(codigo)) {
				return ph;
			}
		}
		for (Terreno terreno : terrenos) {
			if (terreno.getCodigo().equals(codigo)) {
				return terreno;
			}
		}
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

	// mostrar propiedades según su tipo
	public String mostrarPropiedades(TiposDePropiedades tipo) {
		String resultado = "";

		switch (tipo) {
		case CASA:
			for (Casa casa : casas) {
				resultado += casa.toString() + "\n";
			}
			break;
		case DEPARTAMENTO:
			for (Departamento departamento : departamentos) {
				resultado += departamento.toString() + "\n";
			}
			break;
		case PH:
			for (PH ph : phs) {
				resultado += ph.toString() + "\n";
			}
			break;
		case TERRENO:
			for (Terreno terreno : terrenos) {
				resultado += terreno.toString() + "\n";
			}
			break;
		case CAMPO:
			for (Campo campo : campos) {
				resultado += campo.toString() + "\n";
			}
			break;
		default:
			resultado = "Tipo de propiedad no reconocido.";
			break;
		}

		return resultado;
	}

	// modificar
	public void modificarDatosPropiedad(Propiedad propiedad, Integer datoAModificar, Object dato) {
		switch (datoAModificar) {
		case 1:
			propiedad.setCalle((String) dato);
			break;
		case 2:
			propiedad.setNumero((Integer) dato);
			break;
		case 3:
			propiedad.setLocalidad((String) dato);
			break;
		case 4:
			propiedad.setPrecio((Double) dato);
			break;
		case 5:
			propiedad.setEstaDisponible((Boolean) dato);
			break;
		case 6:
			propiedad.setTipoDeOperacion(TipoDeOperacion.valueOf((String) dato));
			break;
		}
		if (propiedad instanceof Departamento) {
			Departamento departamento = (Departamento) propiedad;
			if (datoAModificar == 7) {
				departamento.setPiso((Integer) dato);
			}
			if (datoAModificar == 8) {
				departamento.setDepartamento((Character) dato);
			}
		} else if (propiedad instanceof PH) {
			PH ph = (PH) propiedad;
			if (datoAModificar == 9) {
				ph.setNumeroDePH((Integer) dato);
			}
		} else if (propiedad instanceof Terreno) {
			Terreno terreno = (Terreno) propiedad;
			if (datoAModificar == 10) {
				terreno.setMetrosCuadrados((Double) dato);
			}
		} else if (propiedad instanceof Campo) {
			Campo campo = (Campo) propiedad;
			if (datoAModificar == 11) {
				campo.setHectareas((Double) dato);
			}
		}
	}

	// ordenar tipo propiedad por precio
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

	// ordenar tipo propiedad por localidad
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

	// buscar tipo de propiedad por precio de precio
	public LinkedList<Casa> buscarCasasPorRangoDePrecio(double precioMinimo, double precioMaximo) {
		LinkedList<Casa> casasEnRango = new LinkedList<Casa>();
		
		for (Casa actualCasa : casas) {
			if (actualCasa.getPrecio() >= precioMinimo && actualCasa.getPrecio() <= precioMaximo) {
				casasEnRango.add(actualCasa);
			}
		}

		Collections.sort(casasEnRango, Comparator.comparingDouble(Casa::getPrecio));

		return casasEnRango.isEmpty() ? null : casasEnRango;
	}

	public LinkedList<Departamento> buscarDepartamentosPorRangoDePrecio(double precioMinimo, double precioMaximo) {
		LinkedList<Departamento> departamentosEnRango = new LinkedList<Departamento>();

		for (Departamento actualDepartamento : departamentos) {
			if (actualDepartamento.getPrecio() >= precioMinimo && actualDepartamento.getPrecio() <= precioMaximo) {
				departamentosEnRango.add(actualDepartamento);
			}
		}

		Collections.sort(departamentosEnRango, Comparator.comparingDouble(Departamento::getPrecio));

		return departamentosEnRango.isEmpty() ? null : departamentosEnRango;
	}

	public LinkedList<PH> buscarPhsPorRangoDePrecio(double precioMinimo, double precioMaximo) {
		LinkedList<PH> phsEnRango = new LinkedList<PH>();

		for (PH actualPh : phs) {
			if (actualPh.getPrecio() >= precioMinimo && actualPh.getPrecio() <= precioMaximo) {
				phsEnRango.add(actualPh);
			}
		}

		Collections.sort(phsEnRango, Comparator.comparingDouble(PH::getPrecio));

		return phsEnRango.isEmpty() ? null : phsEnRango;
	}

	public LinkedList<Terreno> buscarTerrenosPorRangoDePrecio(double precioMinimo, double precioMaximo) {
		LinkedList<Terreno> terrenosEnRango = new LinkedList<Terreno>();

		for (Terreno actualTerreno : terrenos) {
			if (actualTerreno.getPrecio() >= precioMinimo && actualTerreno.getPrecio() <= precioMaximo) {
				terrenosEnRango.add(actualTerreno);
			}
		}

		Collections.sort(terrenosEnRango, Comparator.comparingDouble(Terreno::getPrecio));

		return terrenosEnRango.isEmpty() ? null : terrenosEnRango;
	}

	public LinkedList<Campo> buscarCamposPorRangoDePrecio(double precioMinimo, double precioMaximo) {
		LinkedList<Campo> camposEnRango = new LinkedList<Campo>();

		for (Campo actualCampo : campos) {
			if (actualCampo.getPrecio() >= precioMinimo && actualCampo.getPrecio() <= precioMaximo) {
				camposEnRango.add(actualCampo);
			}
		}

		Collections.sort(camposEnRango, Comparator.comparingDouble(Campo::getPrecio));

		return camposEnRango.isEmpty() ? null : camposEnRango;
	}

	// buscar tipo de propiedad por localidad
	public ArrayList<Casa> buscarCasasPorLocalidad(String localidadDeseada) {
		ArrayList<Casa> casasConLocalidadBuscada = new ArrayList<Casa>();

		for (Casa actualCasa : casas) {
			if (actualCasa.getLocalidad().equals(localidadDeseada)) {
				casasConLocalidadBuscada.add(actualCasa);
			}
		}

		return casasConLocalidadBuscada.isEmpty() ? null : casasConLocalidadBuscada;
	}

	public ArrayList<Departamento> buscarDepartamentosPorLocalidad(String localidadDeseada) {
		ArrayList<Departamento> departamentosConLocalidadBuscada = new ArrayList<Departamento>();

		for (Departamento actualDepartamento : departamentos) {
			if (actualDepartamento.getLocalidad().equals(localidadDeseada)) {
				departamentosConLocalidadBuscada.add(actualDepartamento);
			}
		}

		return departamentosConLocalidadBuscada.isEmpty() ? null : departamentosConLocalidadBuscada;
	}

	public ArrayList<PH> buscarPhsPorLocalidad(String localidadDeseada) {
		ArrayList<PH> phsConLocalidadBuscada = new ArrayList<PH>();

		for (PH actualPh : phs) {
			if (actualPh.getLocalidad().equals(localidadDeseada)) {
				phsConLocalidadBuscada.add(actualPh);
			}
		}

		return phsConLocalidadBuscada.isEmpty() ? null : phsConLocalidadBuscada;
	}

	public ArrayList<Terreno> buscarTerrenosPorLocalidad(String localidadDeseada) {
		ArrayList<Terreno> terrenosConLocalidadBuscada = new ArrayList<Terreno>();

		for (Terreno actualTerreno : terrenos) {
			if (actualTerreno.getLocalidad().equals(localidadDeseada)) {
				terrenosConLocalidadBuscada.add(actualTerreno);
			}
		}

		return terrenosConLocalidadBuscada.isEmpty() ? null : terrenosConLocalidadBuscada;
	}

	public ArrayList<Campo> buscarCamposPorLocalidad(String localidadDeseada) {
		ArrayList<Campo> camposConLocalidadBuscada = new ArrayList<Campo>();

		for (Campo actualCampo : campos) {
			if (actualCampo.getLocalidad().equals(localidadDeseada)) {
				camposConLocalidadBuscada.add(actualCampo);
			}
		}

		return camposConLocalidadBuscada.isEmpty() ? null : camposConLocalidadBuscada;
	}

	// buscar tipo de propiedad por operacion
	public ArrayList<Casa> buscarCasasPorOperacion(TipoDeOperacion operacionDeseada) {
		ArrayList<Casa> casasPorOperacionBuscada = new ArrayList<Casa>();

		for (Casa actualCasa : casas) {
			if (actualCasa.getTipoDeOperacion().equals(operacionDeseada)) {
				casasPorOperacionBuscada.add(actualCasa);
			}
		}

		return casasPorOperacionBuscada.isEmpty() ? null : casasPorOperacionBuscada;
	}

	public ArrayList<Departamento> buscarDepartamentosPorOperacion(TipoDeOperacion operacionDeseada) {
		ArrayList<Departamento> departamentosPorOperacionBuscada = new ArrayList<Departamento>();

		for (Departamento actualDepartamento : departamentos) {
			if (actualDepartamento.getTipoDeOperacion().equals(operacionDeseada)) {
				departamentosPorOperacionBuscada.add(actualDepartamento);
			}
		}

		return departamentosPorOperacionBuscada.isEmpty() ? null : departamentosPorOperacionBuscada;
	}

	public ArrayList<PH> buscarPhsPorOperacion(TipoDeOperacion operacionDeseada) {
		ArrayList<PH> phsPorOperacionBuscada = new ArrayList<PH>();

		for (PH actualPh : phs) {
			if (actualPh.getTipoDeOperacion().equals(operacionDeseada)) {
				phsPorOperacionBuscada.add(actualPh);
			}
		}

		return phsPorOperacionBuscada.isEmpty() ? null : phsPorOperacionBuscada;
	}

	public ArrayList<Terreno> buscarTerrenosPorOperacion(TipoDeOperacion operacionDeseada) {
		ArrayList<Terreno> terrenosPorOperacionBuscada = new ArrayList<Terreno>();

		for (Terreno actualTerreno : terrenos) {
			if (actualTerreno.getTipoDeOperacion().equals(operacionDeseada)) {
				terrenosPorOperacionBuscada.add(actualTerreno);
			}
		}

		return terrenosPorOperacionBuscada.isEmpty() ? null : terrenosPorOperacionBuscada;
	}

	public ArrayList<Campo> buscarCamposPorOperacion(TipoDeOperacion operacionDeseada) {
		ArrayList<Campo> camposPorOperacionBuscada = new ArrayList<Campo>();

		for (Campo actualCampo : campos) {
			if (actualCampo.getTipoDeOperacion().equals(operacionDeseada)) {
				camposPorOperacionBuscada.add(actualCampo);
			}
		}

		return camposPorOperacionBuscada.isEmpty() ? null : camposPorOperacionBuscada;
	}

	// calcular precio promedio de cada tipo de propiedad
	public Double calcularPromedioPrecio(int tipoNumerico) {
	    TiposDePropiedades tipo = TiposDePropiedades.values()[tipoNumerico - 1];
		Double sumatoria = 0.0;
		int contador = 0;

		switch (tipo) {
		case CASA:
			for (Casa casa : casas) {
				sumatoria += casa.getPrecio();
				contador++;
			}
			break;
		case DEPARTAMENTO:
			for (Departamento departamento : departamentos) {
				sumatoria += departamento.getPrecio();
				contador++;
			}
			break;
		case PH:
			for (PH ph : phs) {
				sumatoria += ph.getPrecio();
				contador++;
			}
			break;
		case TERRENO:
			for (Terreno terreno : terrenos) {
				sumatoria += terreno.getPrecio();
				contador++;
			}
			break;
		case CAMPO:
			for (Campo campo : campos) {
				sumatoria += campo.getPrecio();
				contador++;
			}
			break;
		default:
			return null;
		}

		return (contador > 0) ? sumatoria / contador : 0.0;
	}
}
