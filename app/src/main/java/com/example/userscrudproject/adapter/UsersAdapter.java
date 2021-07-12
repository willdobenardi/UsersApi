package com.example.userscrudproject.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userscrudproject.EditActivity;
import com.example.userscrudproject.R;
import com.example.userscrudproject.model.User;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.MyViewHolder> {
    List<User> mUserList;

    public UsersAdapter(List <User> userList){
        mUserList=userList;
    }


    @NonNull
    @Override
    public UsersAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_list,parent,false);
        MyViewHolder myViewHolder =new MyViewHolder(mView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final UsersAdapter.MyViewHolder holder, final int position) {
        holder.mTextViewId.setText("Id= "+mUserList.get(position).getId());
        holder.mTextViewName.setText("Name= "+mUserList.get(position).getName());
        holder.mTextViewEmail.setText("Email= "+mUserList.get(position).getEmail());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.mTextViewId.setText("Id = "+mUserList.get(position).getId());
                holder.mTextViewName.setText("Name = "+mUserList.get(position).getName());
                holder.mTextViewEmail.setText("Email = "+mUserList.get(position).getEmail());
                holder.itemView.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Intent mIntent = new Intent(view.getContext(), EditActivity.class);
                        mIntent.putExtra("Id",mUserList.get(position).getId());
                        mIntent.putExtra("Name",mUserList.get(position).getName());
                        mIntent.putExtra("Email",mUserList.get(position).getEmail());
                        view.getContext().startActivity(mIntent);
                    }
                });
            }
        });

    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewName, mTextViewEmail;

        public MyViewHolder(View itemView){
            super(itemView);
            mTextViewId      = (TextView) itemView.findViewById(R.id.tvId);
            mTextViewEmail   = (TextView) itemView.findViewById(R.id.tvName);
            mTextViewName    = (TextView) itemView.findViewById(R.id.tvEmail);
        }
    }
}
