window.addEventListener('load', () => {
  window.listItem = [];
  document.querySelectorAll('ul.todo-list > .todo-list-item').forEach(item => {
    const li = new TodoListItem(item);
    li.init();
    listItem.push(li);
  });
});

class TodoListItem {
  todoNo;
  item;
  checkbox;
  title = {};
  memo = {};
  date = {};
  time = {};
  deleteIcon;

  constructor(DOM) {
    this.item = DOM;
    this.todoNo = DOM.dataset['no'];
    this.checkbox = DOM.querySelector('.todo-checkbox > .mdl-checkbox__input');
    this.title = {
      text: DOM.querySelector('.todo-list-item__title > .todo-list-item__title-text'),
      input: DOM.querySelector('.todo-list-item__title > .todo-list-item__title-input .mdl-textfield__input'),
    };
    this.memo = {
      editing: false,
      text: DOM.querySelector('.todo-list-item__memo'),
      button: DOM.querySelector('.todo-list-item__memo-input-button'),
      input: DOM.querySelector('.todo-list-item__memo-input .mdl-textfield__input'),
    };
    this.date = {
      editing: false,

    };
    this.time = {
      editing: false,

    };

    this.deleteIcon = DOM.querySelector('.todo-list-item__action-delete');
  }

  init() {
    document.addEventListener('click', () => {
      this.item.classList.remove('active');
    }, {capture: true});

    this.item.addEventListener('click', (e) => {
      if (e.target === this.checkbox) {
        return;
      }
      if (this.item.classList.contains('active')) {
        this.item.classList.remove('active');
      } else {
        this.item.classList.add('active');
      }
    }, {capture: true});

    this.checkbox.addEventListener('change', async (e) => {
      const response = await fetch(`/api/todo/${this.todoNo}/status`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: e.target.checked,
      });

      const result = await response.json();
      console.log(result);
    });

    this.deleteIcon.addEventListener('click', async (e) => {
      const response = await fetch(`/api/todo/${this.todoNo}/delete`, {
        method: 'POST'
      });

      const result = await response.json();
      console.log(result);
    });

    this.title.input.addEventListener('blur', async (e) => {

    });
  }

}