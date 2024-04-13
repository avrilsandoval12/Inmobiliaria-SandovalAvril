package ar.edu.unlam.pb1;

import java.nio.channels.NonReadableChannelException;
import java.util.Iterator;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class Inmobiliaria {
	//prueba git

	private String nombre;
	private String direccion;
	private String eMail;
	private Integer telefono;
	private Casa casas[];
	private Departamento departamentos[];
	private PH phs[];
	private Terreno terrenos[];
	private Campo campos[];
	private Cliente clientes[];
	private final Integer CANTIDAD_MAXIMA_DE_PROPIEDADES_POR_TIPO = 100;
	private final Integer CANTIDAD_MAXIMA_DE_CLIENTES = 500;

	public Inmobiliaria(String nombre, String direccion, String eMail, Integer telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.eMail = eMail;
		this.telefono = telefono;
		this.casas = new Casa[CANTIDAD_MAXIMA_DE_PROPIEDADES_POR_TIPO];
		this.departamentos = new Departamento[CANTIDAD_MAXIMA_DE_PROPIEDADES_POR_TIPO];
		this.phs = new PH[CANTIDAD_MAXIMA_DE_PROPIEDADES_POR_TIPO];
		this.terrenos = new Terreno[CANTIDAD_MAXIMA_DE_PROPIEDADES_POR_TIPO];
		this.clientes = new Cliente[CANTIDAD_MAXIMA_DE_CLIENTES];
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

	public Casa[] getCasas() {
		return casas;
	}

	public int getCantidadCasasAgregadas() {
		int count = 0;
		for (Casa casa : this.casas) {
			if (casa != null) {
				count++;
			}
		}
		return count;
	}

	public void setCasas(Casa[] casas) {
		this.casas = casas;
	}

	public Departamento[] getDepartamentos() {
		return departamentos;
	}

	public int getCantidadDepartamentosAgregados() {
		int count = 0;
		for (Departamento departamento : this.departamentos) {
			if (departamento != null) {
				count++;
			}
		}
		return count;
	}

	public void setDepartamentos(Departamento[] departamentos) {
		this.departamentos = departamentos;
	}

	public PH[] getPhs() {
		return phs;
	}

	public int getCantidadPhsAgregados() {
		int count = 0;
		for (PH ph : this.phs) {
			if (ph != null) {
				count++;
			}
		}
		return count;
	}

	public void setPhs(PH[] phs) {
		this.phs = phs;
	}

	public Terreno[] getTerrenos() {
		return terrenos;
	}

	public int getCantidadTerrenosAgregados() {
		int count = 0;
		for (Terreno terreno: this.terrenos) {
			if (terreno != null) {
				count++;
			}
		}
		return count;
	}

	public void setTerrenos(Terreno[] terrenos) {
		this.terrenos = terrenos;
	}

	public Campo[] getCampos() {
		return campos;
	}
	
	public int getCantidadCamposAgregados() {
		int count = 0;
		for (Campo campo: this.campos) {
			if (campo != null) {
				count++;
			}
		}
		return count;
	}


	public void setCampos(Campo[] campos) {
		this.campos = campos;
	}

	public Cliente[] getClientes() {
		return clientes;
	}

	public int getCantidadClientesAgregados() {
		int count = 0;
		for (Cliente cliente: this.clientes) {
			if (cliente != null) {
				count++;
			}
		}
		return count;
	}

	public void setClientes(Cliente[] clientes) {
		this.clientes = clientes;
	}

	// Metodos para agregar propiedades
	public Boolean aniadirCasa(Casa casaNueva) {
		for (int i = 0; i < casas.length; i++) {
			if (casas[i] != null && casas[i].getCalle().equals(casaNueva.getCalle())
					&& casas[i].getNumero().equals(casaNueva.getNumero())
					&& casas[i].getLocalidad().equals(casaNueva.getLocalidad())) {
				return false;
			}
		}
		for (int i = 0; i < casas.length; i++) {
			if (casas[i] == null) {
				casas[i] = casaNueva;
				return true;
			}
		}
		return false;
	}

	public Boolean aniadirDepartamento(Departamento departamentoNuevo) {
		for (int i = 0; i < departamentos.length; i++) {
			if (departamentos[i] != null && departamentos[i].getCalle().equals(departamentoNuevo.getCalle())
					&& departamentos[i].getNumero().equals(departamentoNuevo.getNumero())
					&& departamentos[i].getLocalidad().equals(departamentoNuevo.getLocalidad())
					&& departamentos[i].getPiso().equals(departamentoNuevo.getPiso())
					&& departamentos[i].getDepartamento().equals(departamentoNuevo.getDepartamento())) {
				return false;
			}
		}
		for (int i = 0; i < departamentos.length; i++) {
			if (departamentos[i] == null) {
				departamentos[i] = departamentoNuevo;
				return true;
			}
		}
		return false;

	}

	public Boolean aniadirPH(PH phNuevo) {
		for (int i = 0; i < phs.length; i++) {
			if (phs[i] != null && phs[i].getCalle().equals(phNuevo.getCalle())
					&& phs[i].getNumero().equals(phNuevo.getNumero())
					&& phs[i].getLocalidad().equals(phNuevo.getLocalidad())
					&& phs[i].getNumeroDePH().equals(phNuevo.getNumeroDePH())) {
				return false;
			}
		}
		for (int i = 0; i < phs.length; i++) {
			if (phs[i] == null) {
				phs[i] = phNuevo;
				return true;
			}
		}
		return false;
	}

	public Boolean aniadirTerreno(Terreno terrenoNuevo) {
		for (int i = 0; i < terrenos.length; i++) {
			if (terrenos[i] == null) {
				terrenos[i] = terrenoNuevo;
				return true;
			}
		}
		return false;
	}

	public Boolean aniadirCampo(Campo campoNuevo) {
		for (int i = 0; i < campos.length; i++) {
			if (campos[i] == null) {
				campos[i] = campoNuevo;
				return true;
			}
		}
		return false;
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
		// TODO Auto-generated method stub

	}

	public void modificarDatosPh(PH ph, Integer datoAModificar, Object dato) {
		// TODO Auto-generated method stub

	}

	public void modificarDatosTerreno(Terreno terreno, Integer datoAModificar, Object dato) {
		// TODO Auto-generated method stub

	}

	public void modificarDatosCampo(Campo campo, Integer datoAModificar, Object dato) {
		// TODO Auto-generated method stub

	}

	// Método para añadir un cliente
	public Boolean añadirCliente(Cliente clienteNuevo) {
		for (Cliente cliente : clientes) {
			if (cliente != null && cliente.getDni().equals(clienteNuevo.getDni())) {
				return false;
			}
		}
		for (int i = 0; i < clientes.length; i++) {
			if (clientes[i] == null) {
				clientes[i] = clienteNuevo;
				return true;
			}
		}

		System.out.println("No se pueden añadir más clientes.");
		return false;
	}

	// métodos para odenar propiedades según su tipo
	public void ordenarCasasPorPrecio() {
		for (int i = 0; i < casas.length - 1; i++) {
			for (int j = 0; j < casas.length - i - 1; j++) {
				if (casas[j].getPrecio() > casas[j + 1].getPrecio()) {
					Casa temp = casas[j];
					casas[j] = casas[j + 1];
					casas[j + 1] = temp;
				}
			}
		}
	}

	public void ordenarDepartamentosPorPrecio() {
		for (int i = 0; i < departamentos.length - 1; i++) {
			for (int j = 0; j < departamentos.length - i - 1; j++) {
				if (departamentos[j].getPrecio() > departamentos[j + 1].getPrecio()) {
					Departamento temp = departamentos[j];
					departamentos[j] = departamentos[j + 1];
					departamentos[j + 1] = temp;
				}
			}
		}
	}

	public void ordenarPHsPorPrecio() {
		for (int i = 0; i < phs.length - 1; i++) {
			for (int j = 0; j < phs.length - i - 1; j++) {
				if (phs[j].getPrecio() > phs[j + 1].getPrecio()) {
					PH temp = phs[j];
					phs[j] = phs[j + 1];
					phs[j + 1] = temp;
				}
			}
		}
	}

	public void ordenarTerrenosPorPrecio() {
		for (int i = 0; i < terrenos.length - 1; i++) {
			for (int j = 0; j < terrenos.length - i - 1; j++) {
				if (terrenos[j].getPrecio() > terrenos[j + 1].getPrecio()) {
					Terreno temp = terrenos[j];
					terrenos[j] = terrenos[j + 1];
					terrenos[j + 1] = temp;
				}
			}
		}
	}

	public void ordenarCamposPorPrecio() {
		for (int i = 0; i < campos.length - 1; i++) {
			for (int j = 0; j < campos.length - i - 1; j++) {
				if (campos[j].getPrecio() > campos[j + 1].getPrecio()) {
					Campo temp = campos[j];
					campos[j] = campos[j + 1];
					campos[j + 1] = temp;
				}
			}
		}
	}

	// Ordenar todas las propiedades por precio

	public void ordenarCasasPorUbicacion() {
		for (int i = 0; i < casas.length - 1; i++) {
			for (int j = 0; j < casas.length - i - 1; j++) {
				if (casas[j].getLocalidad().compareTo(casas[j + 1].getLocalidad()) > 0) {
					Casa temp = casas[j];
					casas[j] = casas[j + 1];
					casas[j + 1] = temp;
				}
			}
		}
	}

	public void ordenarDepartamentosPorUbicacion() {
		for (int i = 0; i < departamentos.length - 1; i++) {
			for (int j = 0; j < departamentos.length - i - 1; j++) {
				if (departamentos[j].getLocalidad().compareTo(departamentos[j + 1].getLocalidad()) > 0) {
					Departamento temp = departamentos[j];
					departamentos[j] = departamentos[j + 1];
					departamentos[j + 1] = temp;
				}
			}
		}
	}

	public void ordenarPhsPorUbicacion() {
		for (int i = 0; i < phs.length - 1; i++) {
			for (int j = 0; j < phs.length - i - 1; j++) {
				if (phs[j].getLocalidad().compareTo(phs[j + 1].getLocalidad()) > 0) {
					PH temp = phs[j];
					phs[j] = phs[j + 1];
					phs[j + 1] = temp;
				}
			}
		}
	}

	public void ordenarTerrenosPorUbicacion() {
		for (int i = 0; i < terrenos.length - 1; i++) {
			for (int j = 0; j < terrenos.length - i - 1; j++) {
				if (terrenos[j].getLocalidad().compareTo(terrenos[j + 1].getLocalidad()) > 0) {
					Terreno temp = terrenos[j];
					terrenos[j] = terrenos[j + 1];
					terrenos[j + 1] = temp;
				}
			}
		}
	}

	public void ordenarCamposPorUbicacion() {
		for (int i = 0; i < campos.length - 1; i++) {
			for (int j = 0; j < campos.length - i - 1; j++) {
				if (campos[j].getLocalidad().compareTo(campos[j + 1].getLocalidad()) > 0) {
					Campo temp = campos[j];
					campos[j] = campos[j + 1];
					campos[j + 1] = temp;
				}
			}
		}
	}

	// buscar propiedades por precio especifico
	public Casa[] buscarCasasPorRangoDePrecio(double precioMinimo, double precioMaximo) {
		Casa[] casasTemporal = new Casa[CANTIDAD_MAXIMA_DE_PROPIEDADES_POR_TIPO];
		int count = 0; // Contador para las casas que cumplen

		for (int i = 0; i < casas.length; i++) {
			if (casas[i] != null) {
				if (casas[i].getPrecio() >= precioMinimo && casas[i].getPrecio() <= precioMaximo) {
					casasTemporal[count++] = casas[i];
				}
			}
		}

		Casa[] casasEnRango = null;

		if (count > 0) {
			casasEnRango = new Casa[count];
			for (int i = 0; i < count; i++) {
				casasEnRango[i] = casasTemporal[i];
			}

			// Ordenar por precio
//			for (int i = 0; i < casasEnRango.length - 1; i++) {
//				for (int j = 0; j < casasEnRango.length - i - 1; j++) {
//					if (casasEnRango[j].getPrecio() > casasEnRango[j + 1].getPrecio()) {
//						Casa temp = casasEnRango[j];
//						casasEnRango[j] = casasEnRango[j + 1];
//						casasEnRango[j + 1] = temp;
//					}
//				}
//			}
		}

		return casasEnRango;
	}

	// TODO
	public Departamento[] buscarDepartamentosPorRangoDePrecio(double precioMinimo, double precioMaximo) {
		return departamentos;
	}

	public PH[] buscarPhsPorRangoDePrecio(double precioMinimo, double precioMaximo) {
		return phs;
	}

	public Terreno[] buscarTerrenosPorRangoDePrecio(double precioMinimo, double precioMaximo) {
		return terrenos;
	}

	public Campo[] buscarCamposPorRangoDePrecio(double precioMinimo, double precioMaximo) {
		return campos;
	}

	public void buscarCasasPorLocalidad(String localidadDeseada) {
		// TODO Auto-generated method stub

	}

	public void buscarDepartamentosPorLocalidad(String localidadDeseada) {
		// TODO Auto-generated method stub

	}

	public void buscarPhsPorLocalidad(String localidadDeseada) {
		// TODO Auto-generated method stub

	}

	public void buscarTerrenosPorLocalidad(String localidadDeseada) {
		// TODO Auto-generated method stub

	}

	public void buscarCamposPorLocalidad(String localidadDeseada) {
		// TODO Auto-generated method stub

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
		for (int i = 0; i < casas.length; i++) {
			if (casas[i] != null) {
				resultado += casas[i] + "\n";

			}
		}
		return resultado;

	}

	public String mostrarDepartamentos() {
		String resultado = "";
		for (int i = 0; i < departamentos.length; i++) {
			if (departamentos[i] != null) {
				resultado += departamentos[i] + "\n";

			}
		}
		return resultado;
	}

	public String mostrarPhs() {
		String resultado = "";
		for (int i = 0; i < phs.length; i++) {
			if (phs[i] != null) {
				resultado += phs[i] + "\n";

			}
		}
		return resultado;
	}

	public String mostrarTerrenos() {
		String resultado = "";
		for (int i = 0; i < terrenos.length; i++) {
			if (terrenos[i] != null) {
				resultado += terrenos[i] + "\n";

			}
		}
		return resultado;
	}

	public String mostrarCampos() {
		String resultado = "";
		for (int i = 0; i < campos.length; i++) {
			if (campos[i] != null) {
				resultado += campos[i] + "\n";

			}
		}
		return resultado;
	}

	public Cliente buscarClientePorDni(Integer dni) {
		for (Cliente cliente : this.clientes) {
			if (cliente.getDni().equals(dni)) {
				return cliente;
			}
		}
		return null;
	}

}
