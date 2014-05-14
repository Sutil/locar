package br.com.locar.app.login.seguranca;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QPerfilUsuario is a Querydsl query type for PerfilUsuario
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPerfilUsuario extends EntityPathBase<PerfilUsuario> {

    private static final long serialVersionUID = 475601815;

    public static final QPerfilUsuario perfilUsuario = new QPerfilUsuario("perfilUsuario");

    public final NumberPath<Integer> cotaEmprestimo = createNumber("cotaEmprestimo", Integer.class);

    public final NumberPath<Integer> duracaoDoEmprestimo = createNumber("duracaoDoEmprestimo", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nome = createString("nome");

    public final ListPath<Permissao, EnumPath<Permissao>> permissoes = this.<Permissao, EnumPath<Permissao>>createList("permissoes", Permissao.class, EnumPath.class);

    public final NumberPath<Integer> version = createNumber("version", Integer.class);

    public QPerfilUsuario(String variable) {
        super(PerfilUsuario.class, forVariable(variable));
    }

    public QPerfilUsuario(Path<? extends PerfilUsuario> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPerfilUsuario(PathMetadata<?> metadata) {
        super(PerfilUsuario.class, metadata);
    }

}

