package com.second.phonebookapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.second.phonebookapp.databinding.ItemCardLayoutBinding;

import java.util.ArrayList;

public class Myadapter extends RecyclerView.Adapter<Myadapter.UserViewHolder> {

    private Context context;
    private ArrayList<User> userArrayList;
    private OnItemClickListener onItemClickListener;

    public Myadapter(Context context, ArrayList<User> userArrayList) {
        this.context = context;
        this.userArrayList = userArrayList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Initializes the ViewHolder and Inflates the Item layout
        ItemCardLayoutBinding binding = DataBindingUtil
                .inflate(
                        LayoutInflater.from(parent.getContext()),
                        R.layout.item_card_layout,
                        parent,
                        false
                );

        return new UserViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        // bind data to an existing ViewHolder
        // Populates the Views in the ViewHolder with data from
        // the dataset

        User currentUser = userArrayList.get(position);
        holder.bind(currentUser); // Use a bind method to set data
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    // View Holder: cache references to the
    // individual views within an item layout
    // of a RecyclerView list or grid.
    public class UserViewHolder extends RecyclerView.ViewHolder {
        private ItemCardLayoutBinding itemCardBinding;

        public UserViewHolder(ItemCardLayoutBinding itemCardBinding) {
            super(itemCardBinding.getRoot());
            this.itemCardBinding = itemCardBinding;

            // Handling Click Events on RecyclerView Items:
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && onItemClickListener != null) {
                        onItemClickListener.onItemClick(position);
                    }
                }
            });
        }

        // Bind method to set data
        public void bind(User user) {
            itemCardBinding.setUser(user);
            itemCardBinding.executePendingBindings();
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
