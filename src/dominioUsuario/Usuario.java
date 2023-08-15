package dominioUsuario;

public class Usuario {
	private int id;
	private String correoElectronico, clave;

	public Usuario(int id, String correoElectronico, String clave) {
		super();
		this.id = id;
		this.correoElectronico = correoElectronico;
		this.clave = clave;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String toString() {
		return "Usuario{id=" + id + ", correo electronico=" + correoElectronico + ", clave=" + clave + "}";
	}
}
