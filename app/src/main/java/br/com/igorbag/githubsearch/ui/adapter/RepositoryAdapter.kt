package br.com.igorbag.githubsearch.ui.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.recyclerview.widget.RecyclerView
import br.com.igorbag.githubsearch.R
import br.com.igorbag.githubsearch.domain.Repository
import br.com.igorbag.githubsearch.ui.MainActivity

class RepositoryAdapter(private val repositories: List<Repository>) :
    RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    var carItemLister: (Repository) -> Unit = {}
    var btnShareLister: (Repository) -> Unit = {}

    // Cria uma nova view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false)
        return ViewHolder(view)
    }

    // Pega o conteudo da view e troca pela informacao de item de uma lista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //@TODO 8 -  Realizar o bind do viewHolder
        //Exemplo de Bind
        val repository = repositories[position]
        holder.nomeRepos.text = repository.name

        // Exemplo de click no item
        //holder.itemView.setOnClickListener {
        // carItemLister(repositores[position])
        //}

        holder.compartilhar.setOnClickListener{
            btnShareLister(repository)
        }

        // Exemplo de click no btn Share
        //holder.favorito.setOnClickListener {
        //    btnShareLister(repositores[position])
        //}

        holder.urlLink.setOnClickListener {
            carItemLister(repository)
        }
    }

    // Pega a quantidade de repositorios da lista
    //@TODO 9 - realizar a contagem da lista
    override fun getItemCount(): Int = repositories.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //@TODO 10 - Implementar o ViewHolder para os repositorios
        //Exemplo:
        val nomeRepos: TextView
        val compartilhar: ImageView
        val urlLink: CardView

        init {
            view.apply {
                nomeRepos = findViewById(R.id.tv_repositorio)
                compartilhar = findViewById(R.id.iv_favorite)
                urlLink = findViewById(R.id.cv_car)
            }
        }
    }
}


