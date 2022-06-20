/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dam2
 */
@Entity
@Table(name = "peliculas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Peliculas.findAll", query = "SELECT p FROM Peliculas p")
    , @NamedQuery(name = "Peliculas.findByCodpelicula", query = "SELECT p FROM Peliculas p WHERE p.codpelicula = :codpelicula")
    , @NamedQuery(name = "Peliculas.findByTitulo", query = "SELECT p FROM Peliculas p WHERE p.titulo = :titulo")
    , @NamedQuery(name = "Peliculas.findByTema", query = "SELECT p FROM Peliculas p WHERE p.tema = :tema")
    , @NamedQuery(name = "Peliculas.findByDuracion", query = "SELECT p FROM Peliculas p WHERE p.duracion = :duracion")
    , @NamedQuery(name = "Peliculas.findByPrecio", query = "SELECT p FROM Peliculas p WHERE p.precio = :precio")})
public class Peliculas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    //@NotNull
    @Column(name = "codpelicula")
    private Integer codpelicula;
    //@Size(max = 50)
    @Column(name = "titulo")
    private String titulo;
    //@Size(max = 20)
    @Column(name = "tema")
    private String tema;
    @Column(name = "duracion")
    private Integer duracion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private BigDecimal precio;

    public Peliculas() {
    }

    public Peliculas(Integer codpelicula) {
        this.codpelicula = codpelicula;
    }

    public Integer getCodpelicula() {
        return codpelicula;
    }

    public void setCodpelicula(Integer codpelicula) {
        this.codpelicula = codpelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codpelicula != null ? codpelicula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Peliculas)) {
            return false;
        }
        Peliculas other = (Peliculas) object;
        if ((this.codpelicula == null && other.codpelicula != null) || (this.codpelicula != null && !this.codpelicula.equals(other.codpelicula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Peliculas[ codpelicula=" + codpelicula + " ]";
    }
    
}
