package pt.ipg.covid_app;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static pt.ipg.covid_app.RecyclerView.mAdapter1;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyViewHolder> {

    private Context context;
    private List<Data> notesList;
    DataBaseHelper db;

    @NonNull
    @Override
    public NotesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.data_recycler, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesAdapter.MyViewHolder holder, final int position) {
        Data note = notesList.get(position);
        holder.idff.setText(Integer.toString(note.getId()));
        holder.nomeff.setText(note.getNome());
        holder.teleff.setText(note.getGenero());
        holder.moradaff.setText(note.getMorada());
        holder.idadeff.setText(note.getIdade());
        holder.generoff.setText(note.getGenero());
        holder.viajarff.setText(note.getViajar());
        holder.asmaff.setText(note.getAsma());
        holder.sintomaff.setText(note.getSintomas());
        holder.resultadoff.setText(note.getResultado());

        holder.nomeff.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showActionsDialog(position);
                return false;
            }
        });
    }

    public NotesAdapter(Context context, List<Data> notesList) {
        this.context = context;
        this.notesList = notesList;
    }
    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView idff;
        public TextView nomeff;
        public TextView teleff;
        public TextView idadeff;
        public TextView moradaff;
        public TextView generoff;
        public TextView viajarff;
        public TextView asmaff;
        public TextView sintomaff;
        public TextView resultadoff;


        public MyViewHolder(@NonNull View view) {
            super(view);

            idff = view.findViewById(R.id.idd);
             nomeff = view.findViewById(R.id.nome);
             teleff = view.findViewById(R.id.tele);
            idadeff = view.findViewById(R.id.idade);
             moradaff = view.findViewById(R.id.morada);
             generoff = view.findViewById(R.id.genero);
            viajarff = view.findViewById(R.id.viajar);
            asmaff = view.findViewById(R.id.asma);
             sintomaff = view.findViewById(R.id.sintoma);
            resultadoff = view.findViewById(R.id.terminar);
        }
    }

    private void showActionsDialog(final int position) {
        CharSequence colors[] = new CharSequence[]{"Editar", "Eliminar"};

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Escolher opção:");
        builder.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    showDialog(position);
                } else {
                    deleteNote(position);
                }
            }
        });
        builder.show();
    }
    private void deleteNote(int position) {
        // deleting the note from db
        db = new DataBaseHelper(context);
        db.deleteNote(notesList.get(position));

        // removing the note from the list
        notesList.remove(position);
        mAdapter1.notifyItemRemoved(position);
    }

    public void showDialog(final int position){
        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(context);
        View view = layoutInflaterAndroid.inflate(R.layout.dialog_layout, null);

        AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(context);
        alertDialogBuilderUserInput.setView(view);

        final EditText inputNoteNome = view.findViewById(R.id.nomeUpdate);
        final EditText inputNoteGenero = view.findViewById(R.id.generoUpdate);
        final EditText inputNoteTele = view.findViewById(R.id.teleUpdate);
        final EditText inputNoteMorada = view.findViewById(R.id.MoradaUpdate);
        final EditText inputNoteIdade = view.findViewById(R.id.idadeUpdate);
        final EditText inputNoteViajar = view.findViewById(R.id.viajouUpdate);
        final EditText inputNoteAsma = view.findViewById(R.id.asmaUpdate);
        final EditText inputNoteSintomas = view.findViewById(R.id.SintomasUpdate);
        final EditText inputNoteResultado = view.findViewById(R.id.resultadoUpdate);

        alertDialogBuilderUserInput
                .setCancelable(false)
                .setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogBox, int id) {
                        updateNote(inputNoteNome.getText().toString(),
                                inputNoteTele.getText().toString(),
                                inputNoteIdade.getText().toString(),
                                inputNoteGenero.getText().toString(),
                                inputNoteMorada.getText().toString(),
                                inputNoteViajar.getText().toString(),
                                inputNoteAsma.getText().toString(),
                                inputNoteSintomas.getText().toString(),
                                inputNoteResultado.getText().toString(),
                                position);

                    }
                })
                .setNegativeButton("Cancelar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                                dialogBox.cancel();
                            }
                        });

        final AlertDialog alertDialog = alertDialogBuilderUserInput.create();
        alertDialog.show();
    }
    private void updateNote(String noteNome, String noteGenero, String noteTele, String noteidade, String noteMorada, String noteViajar, String noteasma, String noteSintoma, String noteresultado, int position) {
        Data n = notesList.get(position);
        // updating note text
        n.setNome(noteNome);
        n.setTele(noteTele);
        n.setGenero(noteGenero);
        n.setMorada(noteMorada);
        n.setIdade(noteidade);
        n.setSintomas(noteSintoma);
        n.setViajar(noteViajar);
        n.setAsma(noteasma);
        n.setResultado(noteresultado);
        db = new DataBaseHelper(context);
        // updating note in db
        db.updateNote(n);
        // refreshing the list
        notesList.set(position, n);
        mAdapter1.notifyItemChanged(position);

    }
}
