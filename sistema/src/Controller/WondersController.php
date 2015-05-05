<?php
namespace App\Controller;

use App\Controller\AppController;

/**
 * Wonders Controller
 *
 * @property \App\Model\Table\WondersTable $Wonders
 */
class WondersController extends AppController
{

    public $paginate = ['contain' => ['Addresses']];


      public function initialize() 
      {
        parent::initialize();
        $this->loadComponent('RequestHandler');
    }

    /**
     * Index method
     *
     * @return void
     */
    public function index()
    {
        $this->set('wonders', $this->paginate($this->Wonders));
        $this->set('_serialize', ['wonders']);
    }

    /**
     * View method
     *
     * @param string|null $id Wonder id.
     * @return void
     * @throws \Cake\Network\Exception\NotFoundException When record not found.
     */
    public function view($id = null)
    {
        $wonder = $this->Wonders->get($id, [
            'contain' => ['Addresses']
        ]);
        $this->set('wonder', $wonder);
        $this->set('_serialize', ['wonder']);
    }

    /**
     * Add method
     *
     * @return void Redirects on successful add, renders view otherwise.
     */
    public function add()
    {
        
        $wonder = $this->Wonders->newEntity($this->request->data(), ['associated'=>['Addresses']]);
        
        if ($this->request->is('post')) {
            $wonder = $this->Wonders->patchEntity($wonder, $this->request->data(), ['associated'=>['Addresses']]);
            if ($this->Wonders->save($wonder)) {
                $this->Flash->success('The wonder has been saved.');
                return $this->redirect(['action' => 'index']);
            } else {
                $this->Flash->error('The wonder could not be saved. Please, try again.');
            }
        }
        $this->set(compact('wonder'));
        $this->set('_serialize', ['wonder']);
    }

    /**
     * Edit method
     *
     * @param string|null $id Wonder id.
     * @return void Redirects on successful edit, renders view otherwise.
     * @throws \Cake\Network\Exception\NotFoundException When record not found.
     */
    public function edit($id = null)
    {
        $wonder = $this->Wonders->get($id, [
            'contain' => []
        ]);
        if ($this->request->is(['patch', 'post', 'put'])) {
            $wonder = $this->Wonders->patchEntity($wonder, $this->request->data);
            if ($this->Wonders->save($wonder)) {
                $this->Flash->success('The wonder has been saved.');
                return $this->redirect(['action' => 'index']);
            } else {
                $this->Flash->error('The wonder could not be saved. Please, try again.');
            }
        }
        $this->set(compact('wonder'));
        $this->set('_serialize', ['wonder']);
    }

    /**
     * Delete method
     *
     * @param string|null $id Wonder id.
     * @return void Redirects to index.
     * @throws \Cake\Network\Exception\NotFoundException When record not found.
     */
    public function delete($id = null)
    {
        $this->request->allowMethod(['post', 'delete']);
        $wonder = $this->Wonders->get($id);
        if ($this->Wonders->delete($wonder)) {
            $this->Flash->success('The wonder has been deleted.');
        } else {
            $this->Flash->error('The wonder could not be deleted. Please, try again.');
        }
        return $this->redirect(['action' => 'index']);
    }
}
