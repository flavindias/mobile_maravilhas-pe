<?php
namespace App\Model\Entity;

use Cake\ORM\Entity;

/**
 * Address Entity.
 */
class Address extends Entity
{

    /**
     * Fields that can be mass assigned using newEntity() or patchEntity().
     *
     * @var array
     */
    protected $_accessible = [
        'city' => true,
        'street' => true,
        'neighborhood' => true,
        'complemento' => true,
        'latitude' => true,
        'longitude' => true,
        'sector' => true,
        'wonder_id' => true,
        'wonder' => true,
    ];
}
