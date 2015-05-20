<?php
namespace App\Model\Entity;

use Cake\ORM\Entity;

/**
 * Wonder Entity.
 */
class Wonder extends Entity
{

    /**
     * Fields that can be mass assigned using newEntity() or patchEntity().
     *
     * @var array
     */
    protected $_accessible = [
        'name' => true,
        'description' => true,
        'type' => true,
        'addresses' => true,
    ];
}
