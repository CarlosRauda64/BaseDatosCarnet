package sv.edu.ues.fia.basedatoscarnet;

import android.app.ListActivity;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MateriaMenuActivity extends ListActivity {

    String[] menu={"Insertar Registro","Eliminar Registro","Consultar Registro",
            "Actualizar Registro"};
    String[] activities={"MateriaInsertarActivity","MateriaEliminarActivity","MateriaConsultarActivity",
            "MateriaActualizarActivity"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this,  android.R.layout.simple_list_item_1,
                menu));

        ListView listView = getListView();
        listView.setBackgroundColor(Color.rgb(110, 221, 118 ));

        ArrayAdapter<String> adapter = new
                ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, menu);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l,View v,int position,long id){
        super.onListItemClick(l, v, position, id);

        String nombreValue=activities[position];

        l.getChildAt(position).setBackgroundColor(Color.rgb(0, 128, 64));

        try{
            Class<?> clase=Class.forName("sv.ues.fia.eisi.basedatoscarnet."+nombreValue);
            Intent inte = new Intent(this,clase);
            this.startActivity(inte);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}