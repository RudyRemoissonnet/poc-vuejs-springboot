import Vue from 'vue'
import Heroes from '@/components/Heroes'

describe('Heroes', () => {
  it('should render correct contents', () => {
    const Constructor = Vue.extend(Heroes)
    const vm = new Constructor().$mount()
    expect(vm.$el.querySelector('.hello h1').textContent).to.equal('Heroes')
  })

  // // Inspecter l'instance au montage du composant
  // it('affecte correctement les messages à la création', () => {
  //   const Constructor = Vue.extend(Heroes)
  //   const vm = new Constructor().$mount()
  //   expect(vm.subTitle).toBe('Heroes')
  // })
  //
  // it('a un attribut subTitle', () => {
  //   expect(typeof Heroes.data).toBe('function');
  //   const defaultData = Heroes.data();
  //   expect(defaultData.subTitle).teBe('Heroes');
  // })
})
