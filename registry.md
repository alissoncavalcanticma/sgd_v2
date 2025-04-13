## Alterações base de dados:

Tabela usuarios:

- status DE STRING PARA INT (0,1)
- id DE INT PARA BIGINT | + AUTO INCREMENT
- email DE STRING(80) PARA STRING(255)
- apelido NULL
- nome_completo NULL
- ADD created_at TIMESTAMP NULL
- ADD updated_at TIMESTAMP NULL