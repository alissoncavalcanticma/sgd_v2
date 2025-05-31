-- SELECT * FROM usuarios;

dominios


-- Users
-- ALTER TABLE usuarios MODIFY status INT(1) NOT NULL;
-- ALTER TABLE usuarios MODIFY id BIGINT AUTO_INCREMENT, NOT NULL;
-- ALTER TABLE usuarios MODIFY email STRING(255);
-- ALTER TABLE usuarios ADD created_at TIMESTAMP NULL;
-- ALTER TABLE usuarios ADD updated_at TIMESTAMP NULL;usuariosresumos

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