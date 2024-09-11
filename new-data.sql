CREATE DEFINER=`root`@`localhost` PROCEDURE `GetUsuariosByOferta`(IN oferta_id INT)
BEGIN
    SELECT u.usu_id, u.usu_nombre, u.usu_email
    FROM tbl_usuarios u
    INNER JOIN tbl_postulaciones p ON u.usu_id = p.usu_id
    WHERE p.ofe_id = oferta_id;
END



CREATE DEFINER=`root`@`localhost` PROCEDURE `ObtenerOfertasPorUsuario`(
    IN p_usu_id INT
)
BEGIN
    SELECT 
        o.ofe_id,
        o.ofe_titulo,
        o.ofe_subtitulo,
        o.ofe_descripcion,
        o.ofe_modalidad,
        o.ofe_ubicacion,
        o.ofe_area,
        o.ofe_tiempo,
        o.ofe_vacantes,
        o.ofe_experiencia,
        o.ofe_salario,
        o.ofe_fe_registro,
        o.ofe_estado,
        e.em_nombre AS empresa_nombre,
        e.em_email AS empresa_email
    FROM 
        tbl_postulaciones p
    INNER JOIN 
        tbl_oferta o ON p.ofe_id = o.ofe_id
    INNER JOIN 
        tbl_empresa e ON o.em_id = e.em_id
    WHERE 
        p.usu_id = p_usu_id;
END