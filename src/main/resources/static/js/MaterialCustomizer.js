class MaterialInputCustomizer {
  DOM;
  object;
  input;
  errorMessage;

  constructor(element) {
    this.DOM = element;
    this.object = element.MaterialTextfield;
    this.input = element.querySelector(`input`);
    this.errorMessage = element.querySelector('.mdl-textfield__error');
  }

  patternValidation(message) {
    if (this.input.validity.patternMismatch) {
      if (this.errorMessage !== null) {
        this.errorMessage.textContent = message;
      }
      return true;
    }
    return false;
  }

  customValidation(criterion, message) {
    if (criterion) {
      this.input.setCustomValidity(message);
      if (this.errorMessage !== null) {
        this.errorMessage.textContent = message;
      }
      this.object.updateClasses_();
      return true;
    }
    return false;
  }

  isBlank() {
    return this.input.value.trim().length === 0;
  }

  blankValidation(message) {
    return this.customValidation(this.isBlank(), message);
  }

  resetValidation() {
    this.input.setCustomValidity('');
    this.errorMessage.textContent = '';
    this.object.updateClasses_();
  }

  addValidationCriteria() {

  }
}

window.addEventListener('load', () => {
  window.textField = {};
  document.querySelectorAll('div.mdl-js-textfield').forEach(item => {
    const input = item.querySelector('input.mdl-textfield__input');
    if (input !== null) {
      textField[input.id] = new MaterialInputCustomizer(item);
    }
  });
});
