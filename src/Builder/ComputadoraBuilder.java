package Builder;

import javax.print.DocFlavor;

// Producto: La computadora que vamos a construir
public class ComputadoraBuilder {
    private final String procesador;
    private final int ram;
    private final String almacenamiento;
    private final String tarjetaGrafica;
    private final boolean wifi;
    private final String sistemaOperativo;
    private ComputadoraBuilder(Builder builder){
        this.procesador = builder.procesador;
        this.ram = builder.ram;
        this.almacenamiento = builder.almacenamiento;
        this.tarjetaGrafica = builder.tarjetaGrafica;
        this.wifi = builder.wifi;
        this.sistemaOperativo = builder.sistemaOperativo;
    }
    public static class Builder {
        private String procesador;
        private int ram;
        private String almacenamiento;
        private String tarjetaGrafica;
        private boolean wifi;
        private String sistemaOperativo;

        //Constructor con parametros obligatorios
        public Builder(String procesador, int ram, String almacenamiento) {
            //Validaciones bascas
            if (procesador == null || procesador.isEmpty()){
                throw new IllegalArgumentException("El procesador es obligatorio");
            }
            if (ram < 0) {
                throw new IllegalArgumentException("La ram es obligatoria");
            }
            if (almacenamiento == null || almacenamiento.isEmpty()) {
                throw new IllegalArgumentException("El alamacenamiento es obligatorio");
            }
            this.procesador = procesador;
            this.ram = ram;
            this.almacenamiento = almacenamiento;

        }
        //Metodos para configurar atributos opcionales (Fluent Interface)
        public Builder conTarjetaGrafica(String grafica){
            this.tarjetaGrafica = grafica;
            return this;
        }
        public Builder conWifi(boolean wifi) {
            this.wifi = wifi;
            return this;
        }
        public Builder conSistemaOperativo(String sistemaOperativo) {
            this.sistemaOperativo = sistemaOperativo;
            return  this;
        }
        public ComputadoraBuilder build() {
            if (ram > 128) {
                throw new IllegalArgumentException("La RAM no puede ser mayor a 128GB");
            }
            return new ComputadoraBuilder(this);
        }
    }

    public String getProcesador() {
        return procesador;
    }

    public int getRam() {
        return ram;
    }

    public String getAlmacenamiento() {
        return almacenamiento;
    }

    public String getTarjetaGrafica() {
        return tarjetaGrafica;
    }

    public boolean isWifi() {
        return wifi;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    @Override
    public String toString() {
        return "ComputadoraBuilder{" +
                "procesador='" + procesador + '\'' +
                ", ram=" + ram +
                ", almacenamiento='" + almacenamiento + '\'' +
                ", tarjetaGrafica='" + tarjetaGrafica + '\'' +
                ", wifi=" + wifi +
                ", sistemaOperativo='" + sistemaOperativo + '\'' +
                '}';
    }
}
