package sv.edu.ues.fia.basedatoscarnet;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends ListActivity {

    String[] menu={"Tabla Alumno","Tabla Nota","Tabla Materia","Llenar Base de Datos"};
    String[] activities={"AlumnoMenuActivity","NotaMenuActivity","MateriaMenuActivity"};
    ControlBDCarnet BDhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu));
        BDhelper=new ControlBDCarnet(this);
    }

    protected void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        if(position!=3){
            String nombreValue=activities[position];
            try{
                Class<?> clase = Class.forName("sv.edu.ues.fia.basedatoscarnet."+nombreValue);
                Intent inte = new Intent(this, clase);
                this.startActivity(inte);
            } catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        } else {
            BDhelper.abrir();
            String tost=BDhelper.llenarBDCarnet();
            BDhelper.cerrar();
            Toast.makeText(this, tost, Toast.LENGTH_SHORT).show();
        }
    }
}