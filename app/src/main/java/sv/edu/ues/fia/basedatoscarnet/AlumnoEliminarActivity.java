package sv.edu.ues.fia.basedatoscarnet;

import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AlumnoEliminarActivity extends Activity {
    EditText editCarnet;
    ControlBDCarnet controlhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno_eliminar);
        controlhelper=new ControlBDCarnet (this);
        editCarnet=(EditText)findViewById(R.id.editCarnet);
    }
    public void eliminarAlumno(View v){
        String regEliminadas;
        Alumno alumno=new Alumno();
        alumno.setCarnet(editCarnet.getText().toString());
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(alumno);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}