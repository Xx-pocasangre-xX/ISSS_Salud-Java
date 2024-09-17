package Modelo;

public class ExpedientesMedicos {
    private String dui;
    private String sexo;
    private String telefono;
    private String tipo_sangre;
    private String edad;
    private String antecedentes_familiares;
    private String problemas_salud_preexistentes;
    private String alergias;
    private String salud_actual;
    private String resultados_examenes_laboratorios;
    private String fichaIngreso;
    private int idExpediente;

    public int getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(int idExpediente) {
        this.idExpediente = idExpediente;
    }
    
     public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }
    
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String getTipo_Sangre() {
        return tipo_sangre;
    }

    public void setTipo_sangre(String tipo_sangre) {
        this.tipo_sangre = tipo_sangre;
    }
    
    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
    
    public String getAntecedentes() {
        return antecedentes_familiares;
    }

    public void setAntecedentes(String antecedentes_familiares) {
        this.antecedentes_familiares = antecedentes_familiares;
    }
    
    public String getProblemasSalud() {
        return problemas_salud_preexistentes;
    }

    public void setProblemasSalud(String problemas_salud_preexistentes) {
        this.problemas_salud_preexistentes = problemas_salud_preexistentes;
    }
    
    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }
    
    public String getSaludActual() {
        return salud_actual;
    }

    public void setSaludActual(String salud_actual) {
        this.salud_actual = salud_actual;
    }
    
    public String getResultadosLab() {
        return resultados_examenes_laboratorios;
    }

    public void setResultadosLab(String resultados_examenes_laboratorios) {
        this.resultados_examenes_laboratorios = resultados_examenes_laboratorios;
    }
    
    public String getFichaIngreso() {
        return fichaIngreso;
    }

    public void setFichaIngreso(String fichaIngreso) {
        this.fichaIngreso = fichaIngreso;
    }
}
