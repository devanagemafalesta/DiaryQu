package org.d3if1102.noteq.ui.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.d3if1102.noteq.model.Motivasi
import org.d3if1102.noteq.R
import org.d3if1102.noteq.databinding.ListItemBinding
import org.d3if1102.noteq.network.MotivateApi

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private val data = mutableListOf<Motivasi>()
    fun updateData(newData: List<Motivasi>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }
    class ViewHolder(
        private val binding: ListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(motivasi: Motivasi) = with(binding) {
            namaTextView.text = motivasi.nama
            Glide.with(imageView.context)
                .load(MotivateApi.getMotivasiUrl(motivasi.imageId))
                .error(R.drawable.ic_baseline_broken_image_24)
                .into(imageView)

            root.setOnClickListener {
                val message = root.context.getString(R.string.message, motivasi.nama)
                Toast.makeText(root.context, message, Toast.LENGTH_LONG).show()
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
