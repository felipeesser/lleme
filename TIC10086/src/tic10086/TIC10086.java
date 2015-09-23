package tic10086;

import org.apache.jena.query.Dataset;
import org.apache.jena.query.ReadWrite;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.tdb.TDBFactory;

public class TIC10086 {

    public static void main(String[] args) {
        String assemblerFile = "C:\\Users\\Luiz Leme\\Software\\apache-jena-fuseki-2.3.0\\run\\configuration\\tic10086.ttl";
        Dataset dataset = TDBFactory.assembleDataset(assemblerFile);
        dataset.begin(ReadWrite.READ);
        Model model = dataset.getDefaultModel();
        for (StmtIterator i = model.listStatements(); i.hasNext();) {
            Statement s = i.nextStatement();
            Resource subj = s.getSubject();
            Property prop = s.getPredicate();
            RDFNode obj = s.getObject();
            
            System.out.println(subj.getURI());
            System.out.println(prop.getURI());
            System.out.println(obj.toString());
            System.out.println("");
        }
        dataset.end();

    }

}
