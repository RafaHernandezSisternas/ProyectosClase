package neodatis_examen_2eva;
import org.neodatis.odb.*;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
public class Neodatis_Examen_2EVA {
    public static void main(String[] args) {
        
        Medico miMedico1 = new Medico("20485771N","Manuel","Martínez Moya","Dermatología");
        Medico miMedico2 = new Medico("43098113P","Sandra","García Díaz","Traumatología");
        Medico miMedico3 = new Medico("10293800L","Sonia","Martínez Ros","Medicina General");
        Medico miMedico4 = new Medico("22098731T","Esteban","Pérez Piquer","Medicina General");
        Medico miMedico5 = new Medico("32847193G","Julio","García Albarado","Traumatología");
        
        ODB odb = ODBFactory.open("hospital.neo");
        
        odb.store(miMedico1);
        odb.store(miMedico2);
        odb.store(miMedico3);
        odb.store(miMedico4);
        odb.store(miMedico5);
        
        ICriterion criterio = Where.or().add(Where.like("apellidos","G%")).add(Where.equal("especialidad","Medicina General"));
        CriteriaQuery query = new CriteriaQuery(Medico.class, criterio);
        
        Objects<Medico> objects = odb.getObjects(query);
        while (objects.hasNext()){
            Medico miMedico = objects.next();
            System.out.println(miMedico.toString());
        }
        odb.close();
        
    }
    
}
