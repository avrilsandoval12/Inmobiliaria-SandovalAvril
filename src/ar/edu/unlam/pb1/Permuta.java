package ar.edu.unlam.pb1;

import java.time.LocalDate;

public class Permuta implements Operacion {
	
	private Propiedad propiedad1;
	private Propiedad propiedad2;
	private Cliente cliente1;
	private Cliente cliente2;
	private LocalDate fecha;

	public Permuta(Propiedad propiedad1, Propiedad propiedad2, Cliente cliente1, Cliente cliente2, LocalDate fecha) {
		this.propiedad1 = propiedad1;
		this.propiedad2 = propiedad2;
		this.cliente1 = cliente1;
		this.cliente2 = cliente2;
		this.fecha = fecha;
	}
	
	@Override
	public void realizarOperacion(Propiedad propiedad1, Cliente cliente1, LocalDate fecha){
		throw new IllegalArgumentException("La operación de permuta debe involucrar dos propiedades y dos clientes");
		
	}
	
	@Override
    public void realizarOperacion(Propiedad propiedad1, Propiedad propiedad2, Cliente cliente1, Cliente cliente2, LocalDate fecha) throws PropiedadNoDisponibleException {
        if (propiedad1.estaDisponiblePara(TipoDeOperacion.PERMUTA) && propiedad2.estaDisponiblePara(TipoDeOperacion.PERMUTA)) {
            cliente1.getPropiedadesCompradas().remove(propiedad1);
            cliente1.getPropiedadesCompradas().add(propiedad2);
            cliente2.getPropiedadesCompradas().remove(propiedad2);
            cliente2.getPropiedadesCompradas().add(propiedad1);

            propiedad1.setPropietario(cliente2);
            propiedad2.setPropietario(cliente1);
            propiedad1.setEstaDisponible(false);
            propiedad2.setEstaDisponible(false);
            this.fecha = fecha;

        } else {
			throw new PropiedadNoDisponibleException("Las propiedades que está intentando permutar no se encuentran disponibles");
        }
    }

	@Override
	public String toString() {
		return "Permuta de propiedades (Códigos: " + propiedad1.getCodigo() + ", " + propiedad2.getCodigo() + ")\nDetalles de las propiedades 1:\n"
				+ propiedad1.toString() + "\nDetalles de la propiedad 2: " + propiedad2.toString() + "\nCliente 1: " + cliente1.toString() + "\nCliente 2: " + cliente2.toString()
				+ "\nFecha: " + fecha.toString();
	}

	@Override
	public Propiedad getPropiedad() {
		return this.propiedad1;
	}
	
	public Propiedad getPropiedad2() {
		return this.propiedad2;
	}
}

