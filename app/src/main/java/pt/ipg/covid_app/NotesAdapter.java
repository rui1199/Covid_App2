package pt.ipg.covid_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

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
    public void onBindViewHolder(@NonNull NotesAdapter.MyViewHolder holder, int position) {
        Data note = notesList.get(position);
        holder.nomeff.setText(note.getNome());
        holder.teleff.setText(note.getGenero());
        holder.moradaff.setText(note.getMorada());
        holder.idadeff.setText(note.getIdade());
        holder.generoff.setText(note.getGenero());
        holder.viajarff.setText(note.getViajar());
        holder.asmaff.setText(note.getAsma());
        holder.sintomaff.setText(note.getSintomas());
        holder.resultadoff.setText(note.getResultado());
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
}
