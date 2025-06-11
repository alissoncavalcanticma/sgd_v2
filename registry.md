## Alterações base de dados:

Tabela usuarios:

```sql
ALTER TABLE usuarios 
    MODIFY  id              BIGINT AUTO_INCREMENT NOT NULL,
    MODIFY  status          INT(1) NOT NULL,
    MODIFY  email           STRING(255),
    MODIFY  apelido         NULL,
    MODIFY  nome_completo   NULL,
    ADD     created_at      TIMESTAMP NULL,
    ADD     updated_at      TIMESTAMP NULL;
    
```

Tabeça resumos:

```sql

ALTER TABLE resumos 
	MODIFY  id                  BIGINT AUTO_INCREMENT NOT NULL, 
	MODIFY  turno               BIGINT, 
	MODIFY  operador            BIGINT,
	ADD     ocorrenciaTecnica   VARCHAR(500),
	ADD     pendencia           VARCHAR(300), 
	ADD     created_at          TIMESTAMP NULL,
	ADD     updated_at          TIMESTAMP NULL;

```

Tabela domínios:

````sql

CREATE TABLE `dominios` (
	`id`            BIGINT NOT NULL AUTO_INCREMENT,
	`codigo`        INT NOT NULL DEFAULT '0',
	`descricao`     VARCHAR(50) NOT NULL DEFAULT '0' COLLATE 'utf8mb3_general_ci',
	`ativo`         INT(1) NOT NULL DEFAULT '1',
	`observacao`    VARCHAR(250) NULL DEFAULT '0' COLLATE 'utf8mb3_general_ci',
	`grupo`         VARCHAR(50) NULL DEFAULT '0' COLLATE 'utf8mb3_general_ci',
	`created_at`    TIMESTAMP NULL,
	`updated_at`    TIMESTAMP NULL,
	 PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB CHARSET=utf8mb4;
;

````

Tabela turnos:

````sql

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

````

Tabela turnos_registro:

````sql

CREATE TABLE turnos_registro (
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
  UNIQUE KEY uq_registro (usuario_id, turno_id, data_turno),
  INDEX idx_usuario (usuario_id),
  INDEX idx_turno   (turno_id),
  CONSTRAINT fk_registro_usuario FOREIGN KEY (usuario_id)
    REFERENCES usuarios (id)
    ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT fk_registro_turno FOREIGN KEY (turno_id)
    REFERENCES turnos (id)
    ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB CHARSET=utf8mb4;


````