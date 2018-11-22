import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MTax {

	public MTax() {

	}

	/*
	 * Recibe una lista de Tax con sus propiedades y regresa una lista de
	 * errores.
	 */
	public static List<String> validate(List<X_Tax> xTaxList) {

		List<String> errorList = new ArrayList<>();

		// List<String> taxCategoryList =
		// MInfoTaxCategory.getTaxCategoryStringList();

		// Variable para validar si existe al menos una tasa no local
		boolean existTaxNoLocal = false;

		List<String> validIds = new ArrayList<>();
		int cont = 0;
		for (X_Tax tax : xTaxList) {
			if (tax.getId() != null) {
				validIds.add(tax.getId().toString());
			}
			if (tax.getTax() == null) {
				errorList.add("El impuesto es obligatorio");
			}
			/*
			else if (!taxCategoryList.contains(tax.getTax())) {
				errorList.add("El impuesto no es un dato valido");
			}
			if (tax.getAmount() == null) {
				errorList.add("El importe es obligatorio");
			}

			if (tax.getTax() == null) {
				errorList.add("El impuesto es obligatorio");
			} else if (!taxCategoryList.contains(tax.getTax())) {
				errorList.add("El impuesto no es un dato valido");
			}

			if (tax.isLocal()) {
				if (tax.isTrasladado() && tax.getTaxAmount() == null) {
					errorList.add("El importe es obligatorio");
				}
			} else {
				if (tax.getTaxAmount() == null) {
					errorList.add("El importe es obligatorio");
				}
			}

			if (tax.isLocal()) {
				if (tax.isTrasladado() && tax.getTaxAmount() == null) {
					errorList.add("El importe es obligatorio");
				}
			} else {
				if (tax.getTaxAmount() == null) {
					errorList.add("El importe es obligatorio");
				}
			}

			*/
			if (!tax.isLocal()) {
				existTaxNoLocal = true;
			}
		}
		if (existTaxNoLocal != true) {
			errorList.add("Debe de incluir al menos una tasa no local");
		}
		if (validIds.size() != TaxsByListId(validIds, false).size()) {
			errorList.add("Existen datos no guardados previamente");
		} else {
			// Se elimino la parte del else, dado que no se encontro sentido de
			// hacer el
			// HashMap y el metodo solo devuelve una lista de errores.
		}
		return errorList;
	}
}
