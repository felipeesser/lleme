package patterns.mediator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EditorVariaveis extends ClasseMediada {

    private Map<String, Double> variaveis = new HashMap<>();

    public EditorVariaveis(Mediador mediador) {
        super(mediador);
    }

    @Override
    public void alterado() {
        mediador.objetoAlterado(this);
    }

    public void setVar(String varName, Double valor) {
        Double old;
        if (varName != null && valor != null) {
            old = variaveis.put(varName, valor);
            if (old == null || !old.equals(valor))
                alterado();
        }
    }

    public Double getVar(String varName) {
        return variaveis.get(varName);
    }

    public Map<String, Double> getVars() {
        return variaveis;
    }

    public Set<String> listVarsNames() {
        return variaveis.keySet();
    }

    public void removeVar(String nome) {
        variaveis.remove(nome);
    }

    public void listVars() {
        for (String nome : variaveis.keySet())
            System.out.println(nome + " = " + variaveis.get(nome));
    }

    void updateVars(Set<String> nomesVars) {
        // Inclui novas variáveis
        for (String nome : nomesVars)
            if (getVar(nome) == null)
                setVar(nome, 0.0);
        // Exclui variáveis obsoletas
        for (String nome : listVarsNames())
            if (!nomesVars.contains(nome))
                removeVar(nome);
    }
}
