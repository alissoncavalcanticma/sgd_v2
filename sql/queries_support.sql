-- SELECT * FROM usuarios;




-- Users
-- ALTER TABLE usuarios MODIFY status INT(1) NOT NULL;
-- ALTER TABLE usuarios MODIFY id BIGINT AUTO_INCREMENT, NOT NULL;
-- ALTER TABLE usuarios MODIFY email STRING(255);
-- ALTER TABLE usuarios ADD created_at TIMESTAMP NULL;
-- ALTER TABLE usuarios ADD updated_at TIMESTAMP NULL;

-- INSERT INTO `tb_user` (`id`, `email`, `name`, `nickname`, `password`, `user`) VALUES (1, 'alisson@alisson.com.br', 'Alisson Cavalcanti', 'Alisson', '123', 'als');


-- Summary


/*
ALTER TABLE resumos 
	MODIFY id BIGINT AUTO_INCREMENT NOT NULL, 
	MODIFY turno BIGINT, 
	MODIFY operador BIGINT,
	ADD ocorrencia_tecnica VARCHAR(500),
	ADD pendencia VARCHAR(300), 
	ADD created_at TIMESTAMP NULL,
	ADD updated_at TIMESTAMP NULL;
-- 
SET @id := 10;
SET @ativo := 1;
SET @grupo := 'ADMIN';


SELECT * 
FROM dominios dm
WHERE dm.ativo = 1


select * from usuarios where email like '%alis%';

-- ALTER TABLE dominios ADD created_at TIMESTAMP NULL;
-- ALTER TABLE dominios ADD updated_at TIMESTAMP NULL;


CREATE TABLE turnos (
  id            BIGINT           NOT NULL AUTO_INCREMENT,
  codigo        INT              NOT NULL,
  inicio        TIME             NOT NULL              COMMENT 'Início do turno',
  fim           TIME             NOT NULL              COMMENT 'Término do turno',
  descricao     VARCHAR(200)     NOT NULL              COMMENT 'Detalhes adicionais',
  status        INT(1)           NOT NULL DEFAULT '1',
  created_at    TIMESTAMP        NOT NULL,
  updated_at    TIMESTAMP        NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB CHARSET=utf8mb4;


CREATE TABLE turnos_registro (
  id            BIGINT           NOT NULL AUTO_INCREMENT,
  codigo        INT              NOT NULL,
  inicio        TIME             NOT NULL              COMMENT 'Início do turno',
  fim           TIME             NOT NULL              COMMENT 'Término do turno',
  descricao     VARCHAR(200)     NOT NULL              COMMENT 'Detalhes adicionais',
  status        INT(1)           NOT NULL DEFAULT '1',
  created_at    TIMESTAMP        NOT NULL,
  updated_at    TIMESTAMP        NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB CHARSET=utf8mb4;



turnos_registroCREATE TABLE turnos_registro (
  id               BIGINT           NOT NULL AUTO_INCREMENT,
  usuario_id       BIGINT           NOT NULL             COMMENT 'FK para tabela de usuários',
  turno_id         BIGINT           NOT NULL             COMMENT 'FK para tabela de turnos',
  data             DATE             NOT NULL             COMMENT 'Data do turno',
  abertura         TIME             NOT NULL             COMMENT 'Entrada',
  encerramento     TIME             NULL                 COMMENT 'Saída',
  status           INT(1)           NOT NULL DEFAULT 1   COMMENT '0=fechado, 1=aberto',
  created_at       TIMESTAMP        NOT NULL,
  updated_at       TIMESTAMP        NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY uq_registro (usuario_id, turno_id, data),
  INDEX idx_usuario (usuario_id),
  INDEX idx_turno   (turno_id),
  CONSTRAINT fk_registro_usuario FOREIGN KEY (usuario_id)
    REFERENCES usuarios (id)
    ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT fk_registro_turno FOREIGN KEY (turno_id)
    REFERENCES turnos (id)
    ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB CHARSET=utf8mb4;