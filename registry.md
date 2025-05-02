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