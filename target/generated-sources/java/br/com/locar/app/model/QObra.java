package br.com.locar.app.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QObra is a Querydsl query type for Obra
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QObra extends EntityPathBase<Obra> {

    private static final long serialVersionUID = 1228390204;

    public static final QObra obra = new QObra("obra");

    public final ListPath<Autor, QAutor> autores = this.<Autor, QAutor>createList("autores", Autor.class, QAutor.class);

    public final EnumPath<Categoria> categoria = createEnum("categoria", Categoria.class);

    public final EnumPath<DisposicaoParaEmprestimo> disposicao = createEnum("disposicao", DisposicaoParaEmprestimo.class);

    public final ListPath<Exemplar, QExemplar> exemplares = this.<Exemplar, QExemplar>createList("exemplares", Exemplar.class, QExemplar.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath titulo = createString("titulo");

    public QObra(String variable) {
        super(Obra.class, forVariable(variable));
    }

    public QObra(Path<? extends Obra> path) {
        super(path.getType(), path.getMetadata());
    }

    public QObra(PathMetadata<?> metadata) {
        super(Obra.class, metadata);
    }

}

