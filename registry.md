## Alterações base de dados:

Tabela usuarios:

```sql
ALTER TABLE usuarios 
    MODIFY id BIGINT AUTO_INCREMENT NOT NULL,
    MODIFY status INT(1) NOT NULL,
    MODIFY email STRING(255),
    MODIFY apelido NULL,
    MODIFY nome_completo NULL,
    ADD created_at TIMESTAMP NULL,
    ADD updated_at TIMESTAMP NULL;
    
```

Tabeça resumos:

```sql

ALTER TABLE resumos 
	MODIFY id BIGINT AUTO_INCREMENT NOT NULL, 
	MODIFY turno BIGINT, 
	MODIFY operador BIGINT,
	ADD ocorrenciaTecnica VARCHAR(500),
	ADD pendencia VARCHAR(300), 
	ADD created_at TIMESTAMP NULL,
	ADD updated_at TIMESTAMP NULL;

```

Tabela domínios:

````sql

CREATE TABLE `dominios` (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`codigo` INT NOT NULL DEFAULT '0',
	`descricao` VARCHAR(50) NOT NULL DEFAULT '0' COLLATE 'utf8mb3_general_ci',
	`ativo` INT(1) NOT NULL DEFAULT '1',
	`observacao` VARCHAR(250) NULL DEFAULT '0' COLLATE 'utf8mb3_general_ci',
	`grupo` VARCHAR(50) NULL DEFAULT '0' COLLATE 'utf8mb3_general_ci',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;



````