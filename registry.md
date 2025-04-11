## Alterações base de dados:

Tabela usuarios:

- status DE STRING PARA INT (0,1)
- id DE INT PARA BIGINT | + AUTO INCREMENT
- email DE STRING(80) PARA STRING(255)
- apelido NOT NULL
- nome_completo NOT NULL
- ADD created_at TIMESTAMP
- ADD updated_at TIMESTAMP