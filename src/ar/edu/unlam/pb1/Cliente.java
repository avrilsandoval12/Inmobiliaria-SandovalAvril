package ar.edu.unlam.pb1;

import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class Cliente {
	//prueba git

	private Integer dni;
	private String nombre;
	private String apellido;
	private TiposDePropiedades tipoPropiedadInteres;
	private Boolean poseePropiedadParaPermuta;
	private Casa[] casasCompradas;
	private Casa[] casasAlquiladas;
	private Departamento[] deptosComprados;
	private Departamento[] deptosAlquilados;
	private PH[] phsComprados;
	private PH[] phsAlquilados;
	private Terreno[] terrenosComprados;
	private Terreno[] terrenosAlquilados;
	private Campo[] camposComprados;
	private Campo[] camposAlquilados;

	public Cliente(Integer dni, String nombre, String apellido, TiposDePropiedades tipoPropiedadInteres,
			Boolean poseePropiedadParaPermuta) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoPropiedadInteres = tipoPropiedadInteres;
		this.poseePropiedadParaPermuta = poseePropiedadParaPermuta;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public TiposDePropiedades getTipoPropiedadInteres() {
		return tipoPropiedadInteres;
	}

	public void setTipoPropiedadInteres(TiposDePropiedades tipoPropiedadInteres) {
		this.tipoPropiedadInteres = tipoPropiedadInteres;
	}

	public Boolean getPoseePropiedadParaPermuta() {
		return poseePropiedadParaPermuta;
	}

	public void setPoseePropiedadParaPermuta(Boolean poseePropiedadParaPermuta) {
		this.poseePropiedadParaPermuta = poseePropiedadParaPermuta;
	}

	public void comprarCasa(Casa casa) {
		if (casa.estaDisponibleParaVenta()) {
			for (int i = 0; i < this.casasCompradas.length; i++) {
				if (this.casasCompradas[i] == null) {
					this.casasCompradas[i] = casa;
					break;
				}
			}
			casa.setEstaDisponible(false);
			System.out.println("La propiedad ha sido comprada exitosamente.");
		} else {
			System.out.println("La propiedad no está disponible para la venta.");
		}
	}

	public void alquilarCasa(Casa casa) {
		if (casa.estaDisponibleParaAlquiler()) {
			for (int i = 0; i < this.casasAlquiladas.length; i++) {
				if (this.casasCompradas[i] == null) {
					this.casasCompradas[i] = casa;
					break;
				}
			}
			casa.setEstaDisponible(false);
			System.out.println("La propiedad ha sido alquilada exitosamente.");
		} else {
			System.out.println("La propiedad no está disponible para su alquiler.");
		}
	}

	public void comprarDepto(Departamento departamento) {
		if (departamento.estaDisponibleParaVenta()) {
			for (int i = 0; i < this.deptosComprados.length; i++) {
				if (this.deptosComprados[i] == null) {
					this.deptosComprados[i] = departamento;
					break;
				}
			}
			departamento.setEstaDisponible(false);
			System.out.println("La propiedad ha sido comprada exitosamente.");
		} else {
			System.out.println("La propiedad no está disponible para la venta.");
		}
	}

	public void alquilarDepto(Departamento departamento) {
		if (departamento.estaDisponibleParaAlquiler()) {
			for (int i = 0; i < this.deptosAlquilados.length; i++) {
				if (this.deptosAlquilados[i] == null) {
					this.deptosAlquilados[i] = departamento;
					break;
				}
			}
			departamento.setEstaDisponible(false);
			System.out.println("La propiedad ha sido alquilada exitosamente.");
		} else {
			System.out.println("La propiedad no está disponible para su alquiler.");
		}
	}

	public void comprarPh(PH ph) {
		if (ph.estaDisponibleParaVenta()) {
			for (int i = 0; i < this.phsComprados.length; i++) {
				if (this.phsComprados[i] == null) {
					this.phsComprados[i] = ph;
					break;
				}
			}
			ph.setEstaDisponible(false);
			System.out.println("La propiedad ha sido comprada exitosamente.");
		} else {
			System.out.println("La propiedad no está disponible para la venta.");
		}
	}

	public void alquilarPh(PH ph) {
		if (ph.estaDisponibleParaAlquiler()) {
			for (int i = 0; i < this.phsAlquilados.length; i++) {
				if (this.phsAlquilados[i] == null) {
					this.phsAlquilados[i] = ph;
					break;
				}
			}
			ph.setEstaDisponible(false);
			System.out.println("La propiedad ha sido alquilada exitosamente.");
		} else {
			System.out.println("La propiedad no está disponible para su alquiler.");
		}
	}

	public void comprarTerreno(Terreno terreno) {
		if (terreno.estaDisponibleParaVenta()) {
			for (int i = 0; i < this.terrenosComprados.length; i++) {
				if (this.terrenosComprados[i] == null) {
					this.terrenosComprados[i] = terreno;
					break;
				}
			}
			terreno.setEstaDisponible(false);
			System.out.println("La propiedad ha sido comprada exitosamente.");
		} else {
			System.out.println("La propiedad no está disponible para la venta.");
		}
	}

	public void alquilarTerreno(Terreno terreno) {
		if (terreno.estaDisponibleParaAlquiler()) {
			for (int i = 0; i < this.terrenosAlquilados.length; i++) {
				if (this.terrenosAlquilados[i] == null) {
					this.terrenosAlquilados[i] = terreno;
					break;
				}
			}
			terreno.setEstaDisponible(false);
			System.out.println("La propiedad ha sido alquilada exitosamente.");
		} else {
			System.out.println("La propiedad no está disponible para su alquiler.");
		}
	}

	public void comprarCampo(Campo campo) {
		if (campo.estaDisponibleParaVenta()) {
			for (int i = 0; i < this.camposComprados.length; i++) {
				if (this.camposComprados[i] == null) {
					this.camposComprados[i] = campo;
					break;
				}
			}
			campo.setEstaDisponible(false);
			System.out.println("La propiedad ha sido comprada exitosamente.");
		} else {
			System.out.println("La propiedad no está disponible para la venta.");
		}
	}

	public void alquilarCampo(Campo campo) {
		if (campo.estaDisponibleParaAlquiler()) {
			for (int i = 0; i < this.camposAlquilados.length; i++) {
				if (this.camposAlquilados[i] == null) {
					this.camposAlquilados[i] = campo;
					break;
				}
			}
			campo.setEstaDisponible(false);
			System.out.println("La propiedad ha sido alquilada exitosamente.");
		} else {
			System.out.println("La propiedad no está disponible para su alquiler.");
		}
	}
}
