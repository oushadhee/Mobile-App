package com.example.dietplan.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

import com.example.dietplan.databinding.PlanLayoutBinding
import com.example.dietplan.fragment.HomeFragmentDirections
import com.example.dietplan.model.Plan

class PlanAdapter :RecyclerView.Adapter<PlanAdapter.PlanViewHolder>() {

    class PlanViewHolder(val itemBinding: PlanLayoutBinding): RecyclerView.ViewHolder(itemBinding.root)

    private val differCallback = object : DiffUtil.ItemCallback<Plan>() {

    override fun areItemsTheSame(oldItem:Plan, newItem: Plan): Boolean {
        return oldItem.id == newItem.id &&
                oldItem.adddate == newItem.adddate &&
                oldItem.addmenu == newItem.addmenu
    }

    override fun areContentsTheSame(oldItem: Plan, newItem:Plan): Boolean{
      return oldItem == newItem
    }
}
val differ = AsyncListDiffer(this,differCallback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanViewHolder {
       return PlanViewHolder(
           PlanLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
       )
    }

    override fun getItemCount(): Int {
       return differ.currentList.size
    }

    override fun onBindViewHolder(holder: PlanViewHolder, position: Int) {
        val currentPlan = differ.currentList[position]

        holder.itemBinding.adddate.text = currentPlan.adddate
        holder.itemBinding.addmenu.text = currentPlan.addmenu

        holder.itemView.setOnClickListener {
            val direction = HomeFragmentDirections.actionHomeFragmentToEditPlanFragment(currentPlan)
            it.findNavController().navigate(direction)
        }
    }

}