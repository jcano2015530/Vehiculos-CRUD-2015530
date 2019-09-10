package org.josecano.dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author programacion
 */
@Entity
@Table (name="Vehiculos")
public class Vehiculo implements Serializable {

//    private static final long serialVersionUID = 1L;
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name="codigoVehiculo")
    private int codigoVehiculo;
    @Column
    private String marcaVehiculo;
    @Column
    private String tipoVehiculo;
    @Column
    private String estadoVehiculo;
    @Column 
    private String placaVehiculo;

    public Vehiculo() {
    }

    public Vehiculo(int codigoVehiculo, String marcaVehiculo, String tipoVehiculo, String estadoVehiculo, String placaVehiculo) {
        this.codigoVehiculo = codigoVehiculo;
        this.marcaVehiculo = marcaVehiculo;
        this.tipoVehiculo = tipoVehiculo;
        this.estadoVehiculo = estadoVehiculo;
        this.placaVehiculo = placaVehiculo;
    }

    public int getCodigoVehiculo() {
        return codigoVehiculo;
    }

    public void setCodigoVehiculo(int codigoVehiculo) {
        this.codigoVehiculo = codigoVehiculo;
    }

    public String getMarcaVehiculo() {
        return marcaVehiculo;
    }

    public void setMarcaVehiculo(String marcaVehiculo) {
        this.marcaVehiculo = marcaVehiculo;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getEstadoVehiculo() {
        return estadoVehiculo;
    }

    public void setEstadoVehiculo(String estadoVehiculo) {
        this.estadoVehiculo = estadoVehiculo;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    

 

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoVehiculo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if (this.codigoVehiculo != other.codigoVehiculo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "codigoVehiculo=" + codigoVehiculo + ", marcaVehiculo=" + marcaVehiculo + ", tipoVehiculo=" + tipoVehiculo + ", estadoVehiculo=" + estadoVehiculo + ", placaVehiculo=" + placaVehiculo + '}';
    }

    
}
