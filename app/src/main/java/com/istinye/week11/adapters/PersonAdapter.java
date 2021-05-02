package com.istinye.week11.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.istinye.week11.MainActivity;
import com.istinye.week11.R;
import com.istinye.week11.listeners.ItemClickListener;
import com.istinye.week11.models.Person;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    private List<Person> myRecyclerViewData;
    private Context myContext;
    private ItemClickListener myListener;


    public PersonAdapter(Context context, List<Person> personListData) {
        myContext = context;
        myRecyclerViewData = personListData;
        if (context instanceof MainActivity) {
            myListener = (MainActivity) context;
        }
    }

    public void setMyListener(ItemClickListener myListener) {
        this.myListener = myListener;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myItemView = LayoutInflater.from(myContext).inflate(R.layout.layout_recyclerview_item, parent, false);
        return new PersonViewHolder(myItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder viewHolder, int position) {
        Person myPerson = myRecyclerViewData.get(position);

        viewHolder.itemView.setTag(myPerson);
        viewHolder.nameTextView.setText(myPerson.getName());
        viewHolder.surnameTextView.setText(myPerson.getSurname());
        viewHolder.profilePictureImageView.setImageDrawable(myContext.getDrawable(myPerson.getProfilePictureId()));
    }

    @Override
    public int getItemCount() {
        if (myRecyclerViewData == null) return 0;
        return myRecyclerViewData.size();
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView surnameTextView;
        private ImageView profilePictureImageView;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);

            profilePictureImageView = itemView.findViewById(R.id.profilePicture);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            surnameTextView = itemView.findViewById(R.id.surnameTextView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (myListener != null) {
                        Object tagObject = view.getTag();
                        if (tagObject == null) return;
                        Person myPerson = (Person) tagObject;
                        myListener.onItemClick(myRecyclerViewData.indexOf(myPerson));
                    }
                }
            });
        }
    }

}
